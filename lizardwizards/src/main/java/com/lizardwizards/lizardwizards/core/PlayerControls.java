package com.lizardwizards.lizardwizards.core;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayerControls {
    boolean wPressed = false, dPressed = false, sPressed = false, aPressed = false, moveChanged = false;
    boolean upPressed = false, rightPressed = false, downPressed = false, leftPressed = false, shootChanged = false;

    public Vector2 HandleMovement()
    {
        if (moveChanged)
        {
            moveChanged = false;
            Vector2 newDirection = new Vector2(0,0);
            if (wPressed) { newDirection.AddVector(new Vector2(0,-1));}
            if (dPressed) { newDirection.AddVector(new Vector2(1,0));}
            if (sPressed) { newDirection.AddVector(new Vector2(0,1));}
            if (aPressed) { newDirection.AddVector(new Vector2(-1,0));}
            return newDirection.Normalize();
        }
        return null;
    }

    public Vector2 HandleShooting()
    {
        if (shootChanged)
        {
            shootChanged = false;
            Vector2 newDirection = new Vector2(0,0);
            if (upPressed) { newDirection.AddVector(new Vector2(0,-1));}
            if (rightPressed) { newDirection.AddVector(new Vector2(1,0));}
            if (downPressed) { newDirection.AddVector(new Vector2(0,1));}
            if (leftPressed) { newDirection.AddVector(new Vector2(-1,0));}
            return newDirection.Normalize();
        }
        return null;
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
