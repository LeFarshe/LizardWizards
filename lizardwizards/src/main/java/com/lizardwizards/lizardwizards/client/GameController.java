package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Gun;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import com.lizardwizards.lizardwizards.core.gameplay.Projectile;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    List<SpriteWrapper> entities = new ArrayList<>();
    SpriteWrapper currentPlayer;
    PlayerControls playerControls = new PlayerControls();
    Pane root;

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
                if (newMovement != null) { ((Player)currentPlayer.entity).StartMoving(newMovement);}

                Vector2 newShooting = playerControls.HandleShooting();
                if (newShooting != null) { ((Player)currentPlayer.entity).StartShooting(newShooting); }

                timeElapsed = (now-prevTime)/1000000000.0;

                ProjectileHandling(((Player)currentPlayer.entity).Shoot(timeElapsed));

                int currentEntity = 0;
                while (currentEntity < entities.size())
                {
                    SpriteWrapper entity = entities.get(currentEntity);
                    entity.MoveByDelta(timeElapsed);
                    if (!entity.entity.IsDestroyed()) { currentEntity ++; }
                    else {
                        root.getChildren().remove(entity.sprite);
                        entities.remove(currentEntity);
                    }
                }
            }
            prevTime = now;
        }

        private void ProjectileHandling(List<Projectile> newProjectiles)
        {
            if (newProjectiles != null) {
                for (Projectile projectile : newProjectiles) {
                    EntitySprite sprite = projectile.GetSprite();
                    root.getChildren().add(sprite);

                    SpriteWrapper newProjectile = new SpriteWrapper(projectile, sprite);
                    entities.add(newProjectile);
                }
            }

        }
    }

    //Temp
    public void SetCurrentPlayer()
    {
        Player player = new Player(new Vector2(0,0), 100);
        player.weapons.add(new Gun());
        EntitySprite playerSprite = new EntitySprite(new Vector2(10,10), new Vector2(20,20));
        currentPlayer = new SpriteWrapper(player, playerSprite);
        entities.add(currentPlayer);
        root.getChildren().add(playerSprite);
    }
}
