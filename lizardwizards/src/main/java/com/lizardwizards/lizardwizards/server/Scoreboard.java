package com.lizardwizards.lizardwizards.server;

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

    public int getScore() {
        synchronized (Scoreboard.class) {
            return score;
        }
    }

    public void addScore(int score) {
        synchronized (Scoreboard.class) {
            this.score += score;
        }
    }

    public void subtractScore(int score) {
        synchronized (Scoreboard.class) {
            this.score -= score;
        }
    }

    public double getBossHealth() {
        synchronized (Scoreboard.class) {
            return bossHealth;
        }
    }

    public void resetBossHealth() {
        bossHealth = 0;
        maxBossHealth = 0;
    }

    public void initBossHealth(double bossHealth) {
        this.bossHealth += bossHealth;
        maxBossHealth += bossHealth;
    }

    public void addBossHealth(double bossHealth) {
        synchronized (Scoreboard.class) {
            this.bossHealth += bossHealth;
        }
    }

    public void subtractBossHealth(double bossHealth) {
        synchronized (Scoreboard.class) {
            this.bossHealth -= bossHealth;
        }
    }
}
