package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.GameController;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import com.lizardwizards.lizardwizards.server.Server;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Utils {

    public static boolean isServer() {
        return LizardWizardsServer.isRunning;
    }

    public static HashMap<UUID, EntityWrapper> getEntityList() {
        if (isServer()) {
            return Server.serverTimer.entities;
        }
        return ClientUtils.gameController.entities;
    }

    public static Player getRandomPlayer() {
        var players = Server.serverTimer.players;
        return (Player)players.get(new Random().nextInt(players.size())).getPlayer().entity;
    }
}
