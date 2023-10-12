package com.lizardwizards.lizardwizards.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.lizardwizards.lizardwizards.client.ui.ConnectionController;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SentPlayerData;
import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import javafx.application.Platform;
import javafx.stage.Stage;

public class ClientConnectionHandler implements Runnable {
    public static ClientConnectionHandler CurrentHandler = null;
    private final Socket clientSocket;
    private final ObjectOutputStream socketOutput;
    private final ObjectInputStream socketInput;
    private final EntityWrapper player;
    private final List<EntityWrapper> connectedplayerList;
    private boolean gameStarted;
    public Stage stage;

    public Thread currentThread;

    public ClientConnectionHandler(String ip, int port) throws IOException {
        if (CurrentHandler != null){
            CurrentHandler.closeConnection();
        }
        connectedplayerList = new LinkedList<>();
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

    public void sendUpdate(Vector2 position, Vector2 movement, Vector2 shooting) {
        send(new SentPlayerData(position, movement, shooting));
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

        //This is the lobby state
        while (!gameStarted){
            var data = listen();
            switch (data.dataType){
                case LobbyUpdate -> {
                    var lobby_status = data.handleLobbyUpdate();
                    if (lobby_status.maxPlayers == lobby_status.readyPlayers.size()) {
                        gameStarted = true;
                        connectedplayerList.clear(); // This is just cleaner
                        connectedplayerList.addAll(lobby_status.readyPlayers);
                        Platform.runLater(() -> {
                            ClientUtils.changeScene(stage, 3);
                            ClientUtils.gameController.SetPlayer(player);
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
        boolean waitingForFirstSync = true;
        while (waitingForFirstSync && gameStarted) {
            var data = listen();
            switch (data.dataType) {
                case SyncPacket -> {
                    ClientUtils.gameController.start((SyncPacket) data.payload);
                    data.handleSyncPacket(ClientUtils.gameController);
                    waitingForFirstSync = false;
                }
                case Room -> {
                    data.handleRoomLoading(ClientUtils.gameController, connectedplayerList);
                }
                case ConnectionInformation -> {
                    if (!data.handleConnectionInformation()) {
                        gameStarted = false;
                    }
                }
                default -> {
                    System.out.println(data.dataType);
                    throw new RuntimeException("Unexpected datatype received from server while waiting for first sync");
                }
            }
        }

        // This is the game state
        while (gameStarted) {
            var data = listen();
            switch (data.dataType) {
                case SyncPacket -> {
                    data.handleSyncPacket(ClientUtils.gameController);
                }
                case Room -> {
                    data.handleRoomLoading(ClientUtils.gameController, connectedplayerList);
                }
                case ConnectionInformation -> {
                    if (!data.handleConnectionInformation()) {
                        gameStarted = false;
                    }
                }
                default ->
                        throw new RuntimeException("Unexpected datatype received from server while in game");
            }
        }
    }
}
