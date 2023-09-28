package com.lizardwizards.lizardwizards;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameController {
    List<Projectile> projectiles = new ArrayList<>();
    Player currentPlayer;
    Pane root;
    HashMap<Integer, Player> otherPlayers;
    boolean wPressed = false, dPressed = false, sPressed = false, aPressed = false, moveChanged = false;
    boolean upPressed = false, rightPressed = false, downPressed = false, leftPressed = false, shootChanged = false;

    GameController(Pane root)
    {
        this.root = root;
        root.setPrefSize(800,600);
        start();
    }
    public void start() {
        SetCurrentPlayer();
        GameTimer temp = new GameTimer();
        temp.start();
        CreatePlayerSprites(true, null);
    }

    private class GameTimer extends AnimationTimer {
        long prevTime = -1;

        GameTimer() {}
        @Override
        public void handle(long now){
            double timeElapsed = 0;
            List<Projectile> newProjectiles = new ArrayList<>();
            if (prevTime >= 0)
            {
                if (moveChanged)
                {
                    moveChanged = false;
                    Vector2 newDirection = new Vector2(0,0);
                    if (wPressed) { newDirection.AddVector(new Vector2(0,-1));}
                    if (dPressed) { newDirection.AddVector(new Vector2(1,0));}
                    if (sPressed) { newDirection.AddVector(new Vector2(0,1));}
                    if (aPressed) { newDirection.AddVector(new Vector2(-1,0));}
                    currentPlayer.StartMoving(newDirection.Normalize());
                }

                if (shootChanged)
                {
                    shootChanged = false;
                    Vector2 newDirection = new Vector2(0,0);
                    if (upPressed) { newDirection.AddVector(new Vector2(0,-1));}
                    if (rightPressed) { newDirection.AddVector(new Vector2(1,0));}
                    if (downPressed) { newDirection.AddVector(new Vector2(0,1));}
                    if (leftPressed) { newDirection.AddVector(new Vector2(-1,0));}
                    currentPlayer.StartShooting(newDirection.Normalize());
                }
                timeElapsed = (now-prevTime)/1000000000.0;
                currentPlayer.Move(timeElapsed);
                ProjectileHandling(currentPlayer.Shoot(timeElapsed), timeElapsed);

            }
            prevTime = now;
        }

        private void ProjectileHandling(List<Projectile> newProjectiles, double delta)
        {
            if (newProjectiles != null) {
                for (Projectile projectile: newProjectiles) {
                    root.getChildren().add(projectile.sprite);
                    projectiles.add(projectile);
                }
            }

            for (int i = 0; i < projectiles.size();)
            {
                Projectile projectile = projectiles.get(i);
                if (projectile.Move(delta))
                {
                    root.getChildren().remove(projectile.sprite);
                    projectiles.remove(i);
                }
                else { i++; }
            }

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
        player.weapons.add(new Gun());
        currentPlayer = player;
    }


    public void SetMovementEvents(Scene scene){
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (!wPressed && e.getCode() == KeyCode.W)
            {
                moveChanged = true;
                wPressed = true;
            }

            if (!dPressed && e.getCode() == KeyCode.D)
            {
                moveChanged = true;
                dPressed = true;
            }

            if (!sPressed && e.getCode() == KeyCode.S)
            {
                moveChanged = true;
                sPressed = true;
            }

            if (!aPressed && e.getCode() == KeyCode.A)
            {
                moveChanged = true;
                aPressed = true;
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED,e -> {
            if (wPressed && e.getCode() == KeyCode.W)
            {
                moveChanged = true;
                wPressed = false;
            }

            if (dPressed && e.getCode() == KeyCode.D)
            {
                moveChanged = true;
                dPressed = false;
            }

            if (sPressed && e.getCode() == KeyCode.S)
            {
                moveChanged = true;
                sPressed = false;
            }

            if (aPressed && e.getCode() == KeyCode.A)
            {
                moveChanged = true;
                aPressed = false;
            }

        });
    }

    public void SetShootingEvents(Scene scene)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (!upPressed && e.getCode() == KeyCode.UP)
            {
                shootChanged = true;
                upPressed = true;
            }

            if (!rightPressed && e.getCode() == KeyCode.RIGHT)
            {
                shootChanged = true;
                rightPressed = true;
            }

            if (!downPressed && e.getCode() == KeyCode.DOWN)
            {
                shootChanged = true;
                downPressed = true;
            }

            if (!leftPressed && e.getCode() == KeyCode.LEFT)
            {
                shootChanged = true;
                leftPressed = true;
            }
        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED,e -> {
            if (upPressed && e.getCode() == KeyCode.UP)
            {
                shootChanged = true;
                upPressed = false;
            }

            if (rightPressed && e.getCode() == KeyCode.RIGHT)
            {
                shootChanged = true;
                rightPressed = false;
            }

            if (downPressed && e.getCode() == KeyCode.DOWN)
            {
                shootChanged = true;
                downPressed = false;
            }

            if (leftPressed && e.getCode() == KeyCode.LEFT)
            {
                shootChanged = true;
                leftPressed = false;
            }
        });
    }
}
