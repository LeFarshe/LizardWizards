package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.core.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class PlayerHandler {
    private final Player player;
    private final Socket playerSocket;
    private final ObjectInputStream objectInput;
    private final ObjectOutputStream objectOutput;

    PlayerHandler (Socket playerSocket) throws RuntimeException {
        this.playerSocket = playerSocket;
        try {
            objectInput = (ObjectInputStream) playerSocket.getInputStream();
            objectOutput = (ObjectOutputStream) playerSocket.getOutputStream();
            this.player = (Player) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Player could not connect");
        }
    }

    public void synchronize(List<Player> players) throws IOException {
        objectOutput.writeObject(players);
    }
}
