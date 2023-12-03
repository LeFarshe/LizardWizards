package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.client.ui.modals.ConfirmBox;

import javafx.fxml.FXMLLoader;
import javafx.scene.ParallelCamera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;


public class ClientUtils {
    public static GameController gameController = null;
    public static final int gameWidth = 1920;
    public static final int gameHeight = 1080;

    public static void closeProgram(Stage window){
        boolean answer = ConfirmBox.display("Are you sure you want to exit?");
        if (answer) {
            window.close();
        }
    }

    public static void setScreen(Stage window){
        window.setHeight(gameHeight);
        window.setWidth(gameWidth);
        window.setX(0);
        window.setY(0);
    }

    public static URL loadResource(String locationInResourceFolder) {
        return ClientUtils.class.getResource("/com/lizardwizards/lizardwizards/" + locationInResourceFolder);
    }

    public static void setScalingEvents(Pane root){
        var newScene = root.getScene();
        newScene.widthProperty().addListener((obs, oldVal, newVal) -> {
            root.autosize();
            double xScale = gameWidth / newVal.doubleValue();
            double yScale = gameHeight /newScene.getHeight();
            if (xScale < yScale) { return;}
            var camera = newScene.getCamera();
            camera.setScaleX(xScale);
            camera.setScaleY(xScale);
        });

        newScene.heightProperty().addListener((obs, oldVal, newVal) -> {
            root.autosize();
            double xScale = gameWidth / newScene.getWidth();
            double yScale = gameHeight / newVal.doubleValue();
            if (yScale < xScale) { return;}
            var camera = newScene.getCamera();
            camera.setScaleX(yScale);
            camera.setScaleY(yScale);
        });
    }

    public static void changeScene(Stage window,  int stageNum){
        FXMLLoader fxmlLoader;
        Scene newScene;
        switch (stageNum) {
            case 1:
                fxmlLoader = new FXMLLoader(loadResource("connection-view.fxml"));
                break;
            case 2:
                fxmlLoader = new FXMLLoader(loadResource("lobby-view.fxml"));
                break;
            default:
                fxmlLoader = new FXMLLoader(loadResource("menu-view.fxml"));
                break;
        }
        try {
            if (stageNum == 3)
            {
                var root = new Pane();
                var canvas = new Canvas(gameWidth*1.1, gameHeight*1.1);
                root.getChildren().add(canvas);
                newScene = new Scene(root, gameWidth,gameHeight);
                newScene.getStylesheets().add(loadResource("css/fontstyle.css").toExternalForm());
                window.setScene(newScene);
                setScreen(window);
                newScene.setCamera(new ParallelCamera());
                root.autosize();

                gameController = new GameController(canvas);
                gameController.playerControls.SetMovementEvents(newScene);
                gameController.playerControls.SetShootingEvents(newScene);
                gameController.playerControls.SetWeaponSwitchingEvents(newScene);

                setScalingEvents(root);
            }
            else {
                newScene = new Scene(fxmlLoader.load());
                newScene.getStylesheets().add(loadResource("css/fontstyle.css").toExternalForm());
                window.setScene(newScene);
            }
        }
        catch (Exception e){
            System.out.println("I have no idea how u got here. Maybe the error message will help u m8, good luck :) \n Error message:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
