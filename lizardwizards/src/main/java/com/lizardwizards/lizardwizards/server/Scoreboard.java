package com.lizardwizards.lizardwizards.server;

public class Scoreboard {
    private static Scoreboard scoreboard = new Scoreboard();
    private int score = 0;
    private Scoreboard() {
    }

    public static Scoreboard  getInstance(){
        return scoreboard;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void substractScore(int score) {
        this.score -= score;
    }
}
