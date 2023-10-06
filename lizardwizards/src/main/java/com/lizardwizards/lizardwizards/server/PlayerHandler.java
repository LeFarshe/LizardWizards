package com.lizardwizards.lizardwizards.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.UUID;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.*;

public class PlayerHandler {
    private final Session session;
    private final EntityWrapper player;
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

            Player player = new Player(new Vector2(400,300), 100);
            Collider collider = Collider.NewRectangle(new Vector2(400, 300), 20, 20, 0);
            player.weapons.add(new Gun());
            EntitySprite playerSprite = new EntitySprite(new Vector2(0,0), new Vector2(20,20));
            this.player = new EntityWrapper(player, playerSprite, collider);

            session.addPlayer(this);
        } catch (IOException e) {
            throw new RuntimeException("Player could not connect");
        }
    }

    public UUID getPlayerUUID() {
        return player.entity.uuid;
    }

    public EntityWrapper getPlayer() {
        return player;
    }

    public synchronized void synchronizeWithClient(SyncPacket syncPacket) {
        try {
            sendToPlayer(syncPacket, SentDataType.SyncPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateMotion(Vector2 position, Vector2 direction) {
        player.SetPosition(position);
        ((Player)player.entity).StartMoving(direction);
    }

    public void updateShooting(Vector2 direction) {
        ((Player)player.entity).StartShooting(direction);
    }

    public synchronized List<Projectile> processShooting(double delta) {
        return ((Player)player.entity).Shoot(delta);
    }

    public void sendToPlayer(Object data, SentDataType dataType) throws IOException {
        objectOutput.writeObject(new SentServerData(data, dataType));
        objectOutput.flush();
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

    public void stopConnection() {
        try {
            playerSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
