package com.lizardwizards.lizardwizards.client.ui;

import java.util.Observable;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.Weapon;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class GameHUD implements Observer {
    static GameHUD hud;
    Label scoreLabel;
    Label hitPoints;

    ImageView currentWeapon;

    HBox hbox = new HBox();
    BorderPane borderPane = new BorderPane();
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

        currentWeapon = new ImageView(ClientUtils.loadResource("images/loading.png").toExternalForm());
        var bottomPane = new BorderPane();
        bottomPane.setBottom(currentWeapon);
        borderPane.setRight(bottomPane);
        borderPane.setMinWidth(ClientUtils.gameWidth);
        borderPane.setMinHeight(ClientUtils.gameHeight);

        hudElements.add(borderPane);
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

    public void switchWeapon(Weapon weapon) {
        currentWeapon.setImage(weapon.getHudIcon().getImage());
    }

    @Override
    public void update(Observable o, Object hp){
        this.health = (int) hp;
        hitPoints.setText("Health: " + health);
    }
}
