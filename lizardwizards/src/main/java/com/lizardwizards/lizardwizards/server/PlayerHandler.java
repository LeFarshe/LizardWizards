package com.lizardwizards.lizardwizards.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.gameplay.Player;

public class PlayerHandler {
    private final Session session;
    private final Player player;
    private boolean ready = false;
    private Thread currentRunningThread = null;
    private final Socket playerSocket;
    private final ObjectInputStream objectInput;
    private final ObjectOutputStream objectOutput;

    PlayerHandler (Socket playerSocket, Session currentSession) throws RuntimeException {
        session = currentSession;
        this.playerSocket = playerSocket;
        try {
            objectInput = (ObjectInputStream) playerSocket.getInputStream();
            objectOutput = (ObjectOutputStream) playerSocket.getOutputStream();
            this.player = (Player) objectInput.readObject();
            session.addPlayer(this);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Player could not connect");
        }
    }

    // Will need to be atomic as to not interfere with the constant player updates
    public void synchronize() throws IOException {
        objectOutput.writeObject(true);
        objectOutput.flush();
    }

    public void sendToPlayer(Object data, SentDataType dataType) throws IOException {
        objectOutput.writeObject(new SentServerData(data, dataType));
    }

    public void handleLobby() {
        currentRunningThread = new Thread(this::lobbyListener);
        currentRunningThread.start();
    }

    public boolean isReady() {
        return ready;
    }

    public void handleMainGame() {
        if (currentRunningThread != null && currentRunningThread.isAlive()) {
            currentRunningThread.interrupt();
            try {
                objectInput.skipNBytes(objectInput.available());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Loss state here
        // The actual handling of the game goes here
    }

    private void lobbyListener(){
        while (session.getGameState() == GameState.Lobby) {
            try {
                ready = (boolean) objectInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
