package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.core.communication.ScoreboardSyncPacket;

public class Scoreboard {
    private static final Scoreboard scoreboard = new Scoreboard();
    private int score = 0;
    private double maxBossHealth = 0;
    private double bossHealth = 0;
    private Scoreboard() {
    }

    public static Scoreboard  getInstance(){
        synchronized (Scoreboard.class) {
            return scoreboard;
        }
    }

    // TODO: this should ideally not be here, but i currently don't want to bother
    private void sendScoreboardUpdate() {
        if (Server.session != null)
            Server.session.sendToPlayers(new ScoreboardSyncPacket(score, maxBossHealth, bossHealth));
    }

    public int getScore() {
        synchronized (Scoreboard.class) {
            return score;
        }
    }

    public void addScore(int score) {
        synchronized (Scoreboard.class) {
            this.score += score;
            sendScoreboardUpdate();
        }
    }

    public void subtractScore(int score) {
        synchronized (Scoreboard.class) {
            this.score -= score;
            sendScoreboardUpdate();
        }
    }

    public double getBossHealth() {
        synchronized (Scoreboard.class) {
            return bossHealth;
        }
    }

    public void resetBossHealth() {
        synchronized (Scoreboard.class) {
            bossHealth = 0;
            maxBossHealth = 0;
            sendScoreboardUpdate();
        }
    }

    public void initBossHealth(double bossHealth) {
        synchronized (Scoreboard.class) {
            this.bossHealth += bossHealth;
            maxBossHealth += bossHealth;
            sendScoreboardUpdate();
        }
    }

    public void addBossHealth(double bossHealth) {
        synchronized (Scoreboard.class) {
            this.bossHealth += bossHealth;
            sendScoreboardUpdate();
        }
    }

    public void subtractBossHealth(double bossHealth) {
        synchronized (Scoreboard.class) {
            this.bossHealth -= bossHealth;
            sendScoreboardUpdate();
        }
    }
}
