package com.lizardwizards.lizardwizards.client.ui;

import javafx.scene.Node;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class GameHUD {
    static GameHUD hud;
    Label scoreLabel;
    List<Node> hudElements;
    public GameHUD(){
        if (hud == null){
            hud = this;
        }
        hudElements = new ArrayList<>();

        scoreLabel = new Label("Score: 0");
        hudElements.add(scoreLabel);
    }

    public static GameHUD getInstance() { return hud;}

    public void setScore(int score){
        scoreLabel.setText("Score: " + score);
    }

    public List<Node> getHudElements() { return hudElements;}
}