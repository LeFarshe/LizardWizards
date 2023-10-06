package com.lizardwizards.lizardwizards.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.lizardwizards.lizardwizards.client.ui.ConnectionController;
import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import javafx.application.Platform;
import javafx.stage.Stage;

public class ClientConnectionHandler implements Runnable {
    public static ClientConnectionHandler CurrentHandler = null;
    private final Socket clientSocket;
    private final ObjectOutputStream socketOutput;
    private final ObjectInputStream socketInput;
    private final EntityWrapper player;
    private boolean gameStarted;
    public Stage stage;

    public Thread currentThread;

    public ClientConnectionHandler(String ip, int port) throws IOException {
        if (CurrentHandler != null){
            CurrentHandler.closeConnection();
        }
        clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress(ip, port), 3000);
        socketInput = new ObjectInputStream(clientSocket.getInputStream());
        try {
            SentServerData sentServerData = listen();
            if (sentServerData.dataType == SentDataType.ConnectionInformation && sentServerData.handleConnectionInformation()){
                this.player = (EntityWrapper) socketInput.readObject();
            }
            else {
                player = null;
                closeConnection();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        socketOutput = new ObjectOutputStream(clientSocket.getOutputStream());
        CurrentHandler = this;
    }

    public void start() {
        currentThread = new Thread(this);
        currentThread.start();
    }

    public SentServerData listen() {
        SentServerData data = null;

        try {
            data = (SentServerData)socketInput.readObject();

        } catch (IOException | ClassNotFoundException e) {
            closeConnection();
        }

        if (data == null)
            return listen();
        return data;
    }

    private void send(Object object) {
        try {
            socketOutput.writeObject(object);
            socketOutput.flush();
        } catch (IOException e) {
            e.printStackTrace();
            closeConnection();
        }
    }

    public void sendUpdate() {
        send(player);
    }

    public void sendReady(Boolean ready) {
        send(ready);
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
        // Listen for updates and other messages
        // Two states: main game and lobby

        while (!gameStarted){
            var data = listen();
            switch (data.dataType){
                case LobbyUpdate -> {
                    var lobby_status = data.handleLobbyUpdate();
                    if (lobby_status.maxPlayers == lobby_status.readyPlayers.size()) {
                        gameStarted = true;
                        Platform.runLater(() -> {
                            ClientUtils.changeScene(stage, 3);
                        });
                    }
                }
                case ConnectionInformation -> {
                    if (!data.handleConnectionInformation())
                        closeConnection();
                }
                default -> {
                    throw new RuntimeException("Unexpected datatype received from server while in lobby");
                }

            }
        }
        while (true) {
            listen();
        }
    }
}
