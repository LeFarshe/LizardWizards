package com.lizardwizards.lizardwizards.client.ui;

import java.util.*;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.server.Server;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class GameHUD implements Observer {
    static GameHUD hud;
    Label scoreLabel;
    Label hitPoints;
    Canvas bossBar;
    final Color barFrontColor = new Color(0.7, 0.2, 0.25, 1);
    final Color barBackColor = new Color(0.3, 0.2, 0.25, 1);
    ImageView currentWeapon;

    HBox hbox = new HBox();
    BorderPane borderPane = new BorderPane();
    List<Node> hudElements;
    int score;
    int health;
    double maxBossHealth;
    double bossHealth;
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
        bossBar = new Canvas(ClientUtils.gameWidth*0.8, ClientUtils.gameHeight*0.05);
        var bottomPane = new BorderPane();
        bottomPane.setBottom(currentWeapon);
        borderPane.setBottom(bossBar);
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

    public double getMaxBossHealth() {
        return maxBossHealth;
    }

    public void setMaxBossHealth(double maxBossHealth) {
        this.maxBossHealth = maxBossHealth;
        bossBar.setVisible(maxBossHealth > 0);
    }

    public double getBossHealth() {
        return bossHealth;
    }

    public void setBossHealth(double bossHealth) {
        this.bossHealth = bossHealth;
        setBossBar(bossHealth/maxBossHealth);
    }

    private void setBossBar(double healthPercent) {
        var c = bossBar.getGraphicsContext2D();
        var w = bossBar.getWidth();
        var h = bossBar.getHeight();
        c.setFill(barBackColor);
        c.fillRect(0, 0, w, h);
        c.setFill(barFrontColor);
        c.fillRect(0, 0, w*healthPercent, h);
    }

    public void switchWeapon(IWeapon weapon) {
        currentWeapon.setImage(weapon.getHudIcon().getImage());
    }

    @Override
    public void update(Observable o, Object hp){
        this.health = (int) hp;
        hitPoints.setText("Health: " + health);
    }
}
