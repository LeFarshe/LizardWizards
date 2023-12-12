package com.lizardwizards.lizardwizards.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Timer;

import com.lizardwizards.lizardwizards.core.communication.ConnectionInformation;
import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.GameState;

public class Server implements Runnable{
    private final ServerSocket serverSocket;
    public static Session session;
    public static ServerTimer serverTimer;

    @Override
    public void run() {
        try {
            // This is to avoid halting, since accept() would otherwise hold up the thread for no reason
            serverSocket.setSoTimeout(200);
            while (!serverSocket.isClosed() && !session.startGame()) {
                Socket socket;
                try {
                    socket = serverSocket.accept();
                }
                catch (SocketTimeoutException e) {
                    continue;
                }
                if (session.acceptingConnections()) {
                    PlayerHandler player;
                    try {
                        player = new PlayerHandler(socket, session);
                        player.handleLobby();
                    } catch (RuntimeException e) {
                        System.out.printf("%s\nPlayer address: %s\n", e.getMessage(), socket.getInetAddress().toString());
                    }
                }
                else {
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(new ConnectionInformation(GameState.NotConnected));
                    outputStream.close();
                    socket.close();
                }
            }
            // TODO: After the game starts all attempts to connect will be ignored, that is not how it should happen
            // It is possible to fix this by running separate threads for accepting connections and the main game, I will look into that and decide if it is better than the spaghetti this is going to become
            // I didn't look into it yet
            // Put the gameplay state here somewhere
            serverTimer = new ServerTimer();
            Timer timer = new Timer("ServerGameTimerThread");
            timer.schedule(serverTimer, 0, 1);
            while (!serverSocket.isClosed()) { // TODO not this
                Socket socket;
                try {
                    socket = serverSocket.accept();
                }
                catch (SocketTimeoutException e) {
                    continue;
                }
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(new ConnectionInformation(GameState.NotConnected));
                outputStream.close();
                socket.close();
            }
        }
        catch (IOException e) {
            try {
                e.printStackTrace();
                stopServer();
            } catch (IOException ex) {
                System.out.println("Failed to stop server");
                ex.printStackTrace();
            }
        }
    }


    // TODO: turn server into an singleton
    public Server(ServerSocket serverSocket){
        Server.session = new Session();
        this.serverSocket = serverSocket;
    }

    public void stopServer() throws IOException {
        serverSocket.close();
        // Send disconnect
    }
}
