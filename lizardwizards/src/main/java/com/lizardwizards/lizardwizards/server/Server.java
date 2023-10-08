package com.lizardwizards.lizardwizards.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Timer;

import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;

public class Server implements Runnable{
    private final ServerSocket serverSocket;
    private final Session session;

    @Override
    public void run() {
        try {
            serverSocket.setSoTimeout(3000);
            while (!serverSocket.isClosed() && !session.startGame()) {
                Socket socket;
                // This is to avoid halting, since accept() would otherwise hold up the thread for no reason
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
                        System.out.printf("%s\nPlayer address: %s", e.getMessage(), socket.getInetAddress().toString());
                    }
                }
                else {
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(new SentServerData(false, SentDataType.ConnectionInformation));
                    outputStream.close();
                    socket.close();
                }
            }
            // TODO: After the game starts all attempts to connect will be ignored, that is not how it should happen
            // It is possible to fix this by running separate threads for accepting connections and the main game, I will look into that and decide if it is better than the spaghetti this is going to become
            // I didn't look into it yet
            // Put the gameplay state here somewhere
            ServerTimer serverTimer = new ServerTimer(RoomInformation.getTestRoom(), session);
            Timer timer = new Timer("ServerGameTimerThread");
            timer.schedule(serverTimer, 0, 50);
            while (!serverSocket.isClosed()) { // TODO not this
                Socket socket;
                try {
                    socket = serverSocket.accept();
                }
                catch (SocketTimeoutException e) {
                    continue;
                }
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(new SentServerData(false, SentDataType.ConnectionInformation));
                outputStream.close();
                socket.close();
            }
        }
        catch (IOException e) {
            try {
                e.printStackTrace();
                stopServer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Server(ServerSocket serverSocket){
        this.session = new Session();
        this.serverSocket = serverSocket;
    }

    public void stopServer() throws IOException {
        serverSocket.close();
        // Send disconnect
    }
}
