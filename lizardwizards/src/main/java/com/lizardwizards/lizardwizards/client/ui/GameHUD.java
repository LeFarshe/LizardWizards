package com.lizardwizards.lizardwizards.client.ui;

import java.util.Observable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class GameHUD implements Observer {
    static GameHUD hud;
    Label scoreLabel;
    Label hitPoints;

    HBox hbox = new HBox();
    List<Node> hudElements;
    int score;
    int health;
    public GameHUD(){
        if (hud == null){
            hud = this;
        }
        hudElements = new ArrayList<>();

        scoreLabel = new Label("Score: 0");
        score = 0;
        hitPoints = new Label("Health: 4");
        health = 4;
        hbox.getChildren().addAll(scoreLabel, hitPoints);
        hbox.setSpacing(50);
        hudElements.add(hbox);
    }

    public static GameHUD getInstance() { return hud;}

    public void setScore(int score){
        this.score = score;
        scoreLabel.setText("Score: " + score);
    }

    public List<Node> getHudElements() { return hudElements;}

    public int getScore() {
        return score;
    }

    @Override
    public void update(Observable o, Object hp){
        this.health = (int) hp;
        hitPoints.setText("Health: " + health);
    }
}
