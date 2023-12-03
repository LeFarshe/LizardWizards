package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ui.GameHUD;
import com.lizardwizards.lizardwizards.server.Scoreboard;
import javafx.application.Platform;

public class ScoreboardSyncPacket extends SentServerData {
    private final int currentScore;
    private final double bossMaxHealth;
    private final double bossHealth;


    public ScoreboardSyncPacket(int currentScore, double bossMaxHealth, double bossHealth) {
        super(SentDataType.ScoreboardSyncPacket);
        this.currentScore = currentScore;
        this.bossMaxHealth = bossMaxHealth;
        this.bossHealth = bossHealth;
    }
    @Override
    public void execute() {
        Platform.runLater(() -> {
            var hud = GameHUD.getInstance();
            hud.setScore(currentScore);
            hud.setMaxBossHealth(bossMaxHealth);
            hud.setBossHealth(bossHealth);
        });
    }
}
