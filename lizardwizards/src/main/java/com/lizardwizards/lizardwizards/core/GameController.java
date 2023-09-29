package com.lizardwizards.lizardwizards.core;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameController {
    List<Projectile> projectiles = new ArrayList<>();
    Player currentPlayer;
    PlayerControls playerControls = new PlayerControls();
    Pane root;
    HashMap<Integer, Player> otherPlayers;

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
                Vector2 newMovement = playerControls.HandleMovement();
                if (newMovement != null) { currentPlayer.StartMoving(newMovement);}

                Vector2 newShooting = playerControls.HandleShooting();
                if (newShooting != null) { currentPlayer.StartShooting(newShooting); }

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
}
