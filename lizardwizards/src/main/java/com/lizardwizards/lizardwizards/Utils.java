package com.lizardwizards.lizardwizards;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.Console;

public class Utils {
    public static void closeProgram(Stage window){
        Boolean answer = ConfirmBox.display("Are you sure you want to exit?");
        if (answer) {
            window.close();
        }
    }

    // TODO remove the flickering (resizing bug) while changing scenes somehow
    public static void changeScene(Stage window,  int stageNum){
        FXMLLoader fxmlLoader;
        Scene newScene;
        switch (stageNum) {
            case 1:
                fxmlLoader = new FXMLLoader(Utils.class.getResource("connection-view.fxml"));
                break;
            case 2:
                fxmlLoader = new FXMLLoader(Utils.class.getResource("lobby-view.fxml"));
                break;
            case 3:
                fxmlLoader = new FXMLLoader(Utils.class.getResource("game-view.fxml"));
                break;
            default:
                fxmlLoader = new FXMLLoader(Utils.class.getResource("menu-view.fxml"));
                break;
        }
        try {
            newScene = new Scene(fxmlLoader.load());
            if (stageNum == 3)
            {
                GameController tempController = fxmlLoader.getController();
                GameController.SetKeyEvents(newScene, tempController);
            }
            window.setScene(newScene);
        }
        catch (Exception e){
            System.out.println("I have no idea how u got here. Maybe the error message will help u m8, good luck :) \n Error message:" + e.getMessage());
        }
    }
}
