package com.lizardwizards.lizardwizards.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.UUID;

import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.*;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.UpgradedWeaponFactory;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.WeaponFactory;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.WeaponTypes;

public class PlayerHandler {
    private final Session session;
    private final EntityWrapper player;
    private boolean ready = false;
    private Thread currentRunningThread = null;
    private final Socket playerSocket;
    private final ObjectInputStream objectInput;
    private final ObjectOutputStream objectOutput;

    private final WeaponFactory weaponFactory = new UpgradedWeaponFactory(1);

    PlayerHandler (Socket playerSocket, Session currentSession) throws RuntimeException {
        session = currentSession;
        this.playerSocket = playerSocket;
        try {
            objectOutput = new ObjectOutputStream(playerSocket.getOutputStream());
            sendToPlayer(new ConnectionInformation(GameState.InLobby));

            Player player = new Player(new Vector2(0,0), 250);
            Collider collider = Collider.NewRectangle(new Vector2(0, 0), 20, 20, CollisionLayer.Player);
            player.weapons.add(weaponFactory.getWeapon(WeaponTypes.Pistol));
            player.weapons.add(weaponFactory.getWeapon(WeaponTypes.Shotgun));
            player.weapons.add(weaponFactory.getWeapon(WeaponTypes.Chaingun));
            var playerColor = session.sessionColors.get(session.playersConnected%session.sessionColors.size());
            RectangleSprite playerSprite = new RectangleSprite(new Vector2(0,0), new Vector2(20,20), playerColor);
            this.player = new EntityWrapper(player, playerSprite, collider);

            session.addPlayer(this);
            objectOutput.writeObject(this.player);
            objectOutput.flush();
            objectInput = new ObjectInputStream(playerSocket.getInputStream());
            this.playerSocket.setSoTimeout(1000);

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
            sendToPlayer(syncPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateMotion(Vector2 position, Vector2 direction) {
        player.SetPosition(position);
        ((Player)player.entity).StartMoving(direction);
    }

    public void updateWeapon(int weaponSwitch){
        ((Player)player.entity).ChangeWeapon(weaponSwitch);
    }

    public void updateShooting(Vector2 direction) {
        ((Player)player.entity).StartShooting(direction);
    }

    public synchronized List<IProjectile> processShooting(double delta) {
        return ((Player)player.entity).Shoot(delta);
    }

    public void sendToPlayer(SentServerData sentServerData) throws IOException {
        objectOutput.writeObject(sentServerData);
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
            try {
                currentRunningThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentRunningThread = new Thread(this::mainGameListener);
        currentRunningThread.start();
    }

    private void mainGameListener() {
        while (session.getGameState() == GameState.InGame) {
            try {
                SentPlayerData sentPlayerData = (SentPlayerData) objectInput.readObject();

                if (sentPlayerData.weaponSwitch != 0) {
                    updateWeapon(sentPlayerData.weaponSwitch);
                }
                if (sentPlayerData.shooting != null) {
                    updateShooting(sentPlayerData.shooting);
                }
                if (sentPlayerData.movement != null) {
                    updateMotion(sentPlayerData.position, sentPlayerData.movement);
                }
            } catch (SocketTimeoutException ignored) {
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void lobbyListener(){
        System.out.println(player.entity.uuid);
        while (session.getGameState() == GameState.InLobby) {
            try {
                ready = (Boolean) objectInput.readObject();
                session.updateLobby();
            } catch (SocketTimeoutException ignored) {
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stopConnection() {
        try {
            playerSocket.close();
            objectInput.close();
            objectOutput.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
