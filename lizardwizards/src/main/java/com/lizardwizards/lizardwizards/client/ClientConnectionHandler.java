package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.gameplay.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientConnectionHandler implements Runnable {
    private final Socket clientSocket;
    private final ObjectOutputStream socketOutput;
    private final ObjectInputStream socketInput;
    private final Player player;

    ClientConnectionHandler(String ip, int port, Player player) throws IOException {
        this.player = player;
        clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress(ip, port), 3000);
        socketInput = (ObjectInputStream) clientSocket.getInputStream();
        socketOutput = (ObjectOutputStream) clientSocket.getOutputStream();
    }

    public Object listen() {
        Object data = null;

        try {
            data = socketInput.readObject();

        } catch (IOException | ClassNotFoundException e) {
            closeConnection();
        }

        return data;
    }

    public void sendUpdate() {

    }

    public void closeConnection() {
        // Something to inform about the closed connection maybe?
        try {
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

    }
}
