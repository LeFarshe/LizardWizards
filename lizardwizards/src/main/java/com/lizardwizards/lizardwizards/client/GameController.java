package com.lizardwizards.lizardwizards.client;

import java.util.ArrayList;
import java.util.List;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

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
        CreateObstacle(new Vector2(200, 300));
        CreateObstacle(new Vector2(600, 300));
        CreateEnemy(new Vector2(400, 400));
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
                    entity.MoveByDelta(timeElapsed, entities);
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

                    SpriteWrapper newProjectile = new SpriteWrapper(projectile, sprite, projectile.GetCollider());
                    entities.add(newProjectile);
                }
            }

        }
    }

    public void CreateEnemy(Vector2 position){
        Enemy enemy = new Enemy(position, 100);
        EntitySprite sprite = new EntitySprite(position, new Vector2(15, 15));
        Collider collider = Collider.NewRectangle(position, 15, 15, 2);
        SpriteWrapper newEntity = new SpriteWrapper(enemy, sprite, collider);
        entities.add(newEntity);
        root.getChildren().add(sprite);
    }

    public void CreateObstacle(Vector2 position){
        Obstacle obstacle  = new Obstacle(position);
        EntitySprite sprite = new EntitySprite(position, new Vector2(50, 50));
        Collider collider = Collider.NewRectangle(position, 50, 50, 3);
        SpriteWrapper newObstacle = new SpriteWrapper(obstacle, sprite, collider);
        entities.add(newObstacle);
        root.getChildren().add(sprite);
    }

    //Temp
    public void SetCurrentPlayer()
    {
        Player player = new Player(new Vector2(400,300), 100);
        Collider collider = Collider.NewRectangle(new Vector2(400, 300), 20, 20, 0);
        player.weapons.add(new Gun());
        EntitySprite playerSprite = new EntitySprite(new Vector2(0,0), new Vector2(20,20));
        currentPlayer = new SpriteWrapper(player, playerSprite, collider);
        entities.add(currentPlayer);
        root.getChildren().add(playerSprite);
    }
}
