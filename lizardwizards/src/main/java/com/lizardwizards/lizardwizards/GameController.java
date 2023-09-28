package com.lizardwizards.lizardwizards;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.List;

public class GameController {
    Player currentPlayer;
    Pane root;
    HashMap<Integer, Player> otherPlayers;
    boolean wPressed = false, dPressed = false, sPressed = false, aPressed = false, changed = false;

    GameController(Pane root)
    {
        this.root = root;
        root.setPrefSize(800,600);
        start();
    }
    public void start() {
        SetCurrentPlayer();
        GameTimer temp = new GameTimer(currentPlayer);
        temp.start();
        CreatePlayerSprites(true, null);
    }

    private class GameTimer extends AnimationTimer {
        long prevTime = -1;
        Player currentPlayer;

        GameTimer(Player currentPlayer)
        {
            this.currentPlayer = currentPlayer;
        }
        @Override
        public void handle(long now){
            double timeElapsed = 0;
            if (prevTime >= 0)
            {
                if (changed)
                {
                    changed = false;
                    Vector2 newDirection = new Vector2(0,0);
                    if (wPressed) { newDirection.AddVector(new Vector2(0,-1));}
                    if (dPressed) { newDirection.AddVector(new Vector2(1,0));}
                    if (sPressed) { newDirection.AddVector(new Vector2(0,1));}
                    if (aPressed) { newDirection.AddVector(new Vector2(-1,0));}
                    currentPlayer.StartMoving(newDirection.Normalize());
                }
                timeElapsed = (now-prevTime)/1000000000.0;
                currentPlayer.Move(timeElapsed);
            }
            prevTime = now;
        }
    }

    public void CreatePlayerSprites(boolean currentAlive, List<Integer> othersAlive)
    {
        if (currentAlive)
        {
            currentPlayer.sprite = new EntitySprite(new Vector2(10,10), new Vector2(20,20));
            root.getChildren().add(currentPlayer.sprite);
        }
    }
    public void SetCurrentPlayer()
    {
        Player player = new Player(new Vector2(0,0), 100);
        currentPlayer = player;
    }


    public void SetKeyEvents(Scene scene){
        scene.setOnKeyPressed(e -> {
            if (!wPressed && e.getCode() == KeyCode.W)
            {
                changed = true;
                wPressed = true;
            }

            if (!dPressed && e.getCode() == KeyCode.D)
            {
                changed = true;
                dPressed = true;
            }

            if (!sPressed && e.getCode() == KeyCode.S)
            {
                changed = true;
                sPressed = true;
            }

            if (!aPressed && e.getCode() == KeyCode.A)
            {
                changed = true;
                aPressed = true;
            }
        });

        scene.setOnKeyReleased(e -> {
            if (wPressed && e.getCode() == KeyCode.W)
            {
                changed = true;
                wPressed = false;
            }

            if (dPressed && e.getCode() == KeyCode.D)
            {
                changed = true;
                dPressed = false;
            }

            if (sPressed && e.getCode() == KeyCode.S)
            {
                changed = true;
                sPressed = false;
            }

            if (aPressed && e.getCode() == KeyCode.A)
            {
                changed = true;
                aPressed = false;
            }
        });
    }
}
