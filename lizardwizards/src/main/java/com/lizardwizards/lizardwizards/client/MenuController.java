package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button exitButton;
    @FXML
    private Button startButton;


    @FXML
    protected void onExitClick() {
        Utils.closeProgram((Stage) exitButton.getScene().getWindow());
    }

    @FXML
    protected void onStartClick() {
        Utils.changeScene((Stage) startButton.getScene().getWindow(), 1);
    }
}