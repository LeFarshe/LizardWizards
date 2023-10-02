package com.lizardwizards.lizardwizards.client.ui;

import com.lizardwizards.lizardwizards.client.ClientUtils;
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
        ClientUtils.closeProgram((Stage) exitButton.getScene().getWindow());
    }

    @FXML
    protected void onStartClick() {
        ClientUtils.changeScene((Stage) startButton.getScene().getWindow(), 1);
    }
}