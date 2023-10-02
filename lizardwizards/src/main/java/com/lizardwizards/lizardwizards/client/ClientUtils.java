package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.client.ui.modals.ConfirmBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ClientUtils {
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
                fxmlLoader = new FXMLLoader(ClientUtils.class.getResource("/com/lizardwizards/lizardwizards/connection-view.fxml"));
                break;
            case 2:
                fxmlLoader = new FXMLLoader(ClientUtils.class.getResource("/com/lizardwizards/lizardwizards/lobby-view.fxml"));
                break;
            default:
                fxmlLoader = new FXMLLoader(ClientUtils.class.getResource("/com/lizardwizards/lizardwizards/menu-view.fxml"));
                break;
        }
        try {
            if (stageNum == 3)
            {
                Pane root = new Pane();
                newScene = new Scene(root);
                window.setScene(newScene);
                GameController gameController = new GameController(root);
                gameController.playerControls.SetMovementEvents(newScene);
                gameController.playerControls.SetShootingEvents(newScene);
            }
            else {
                newScene = new Scene(fxmlLoader.load());
                window.setScene(newScene);
            }
        }
        catch (Exception e){
            System.out.println("I have no idea how u got here. Maybe the error message will help u m8, good luck :) \n Error message:" + e.getMessage());
        }
    }
}
