package com.lizardwizards.lizardwizards.server;

public class Scoreboard {
    private static Scoreboard scoreboard = new Scoreboard();
    private int score = 0;
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

    public void substractScore(int score) {
        synchronized (Scoreboard.class) {
            this.score -= score;
        }
    }
}
