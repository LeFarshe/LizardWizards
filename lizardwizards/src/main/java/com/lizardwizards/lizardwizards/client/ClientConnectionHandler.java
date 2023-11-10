package com.lizardwizards.lizardwizards.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SentPlayerData;
import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.GameState;
import javafx.stage.Stage;

public class ClientConnectionHandler implements Runnable {
    public static ClientConnectionHandler CurrentHandler = null;
    private final Socket clientSocket;
    private final ObjectOutputStream socketOutput;
    private final ObjectInputStream socketInput;
    public final EntityWrapper player;
    public final List<EntityWrapper> connectedplayerList;
    private GameState gameState = GameState.NotConnected;
    public Stage stage;
    public Thread currentThread;

    public ClientConnectionHandler(String ip, int port) throws IOException {
        if (CurrentHandler != null){
            CurrentHandler.closeConnection();
        }
        CurrentHandler = this;
        connectedplayerList = new LinkedList<>();
        clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress(ip, port), 3000);
        socketInput = new ObjectInputStream(clientSocket.getInputStream());
        try {
            SentServerData sentServerData = listen();
            if (sentServerData.dataType == SentDataType.ConnectionInformation){
                sentServerData.execute();
            }
            if (gameState == GameState.InLobby) {
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

    public void sendUpdate(Vector2 position, Vector2 movement, Vector2 shooting, int weaponSwitch) {
        send(new SentPlayerData(position, movement, shooting, weaponSwitch));
    }

    public void sendReady(Boolean ready) {
        send(ready);
    }

    public void closeConnection() {
        try {
            clientSocket.close();
            CurrentHandler = null;
            currentThread.interrupt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        //This is the lobby state
        while (gameState == GameState.InLobby){
            var data = listen();
            switch (data.dataType){
                case LobbyUpdate, ConnectionInformation -> data.execute();
                default -> {
                    throw new RuntimeException("Unexpected datatype received from server while in lobby");
                }

            }
        }
        boolean waitingForFirstSync = true;
        while (waitingForFirstSync && gameState == GameState.InGame) {
            var data = listen();
            switch (data.dataType) {
                case SyncPacket -> {
                    ClientUtils.gameController.start((SyncPacket) data);
                    data.execute();
                    waitingForFirstSync = false;
                }
                case Room, ConnectionInformation -> data.execute();
                default -> {
                    System.out.println(data.dataType);
                    throw new RuntimeException("Unexpected datatype received from server while waiting for first sync");
                }
            }
        }

        // This is the game state
        while (gameState == GameState.InGame) {
            var data = listen();
            switch (data.dataType) {
                case SyncPacket, ConnectionInformation, Room -> data.execute();
                default ->
                        throw new RuntimeException("Unexpected datatype received from server while in game");
            }
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
