package com.lizardwizards.lizardwizards.client.ui;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.client.ClientUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LobbyController {
    @FXML
    public Label p1;
    @FXML
    public Button p1Button;
    @FXML
    public Button leaveButton;
    @FXML
    public Button classButton;
    public Label p2;
    private boolean ready = false;
    private boolean isBlizzard = true;


    @FXML
    protected void onLeaveClick() {
        ClientUtils.changeScene((Stage) leaveButton.getScene().getWindow(), 0);
    }

    public void toggleReady(ActionEvent actionEvent) {
        ready = !ready;
        if (ready)
            p1Button.setText("Ready");
        else
            p1Button.setText("Not Ready");
        var cch = ClientConnectionHandler.CurrentHandler;
        cch.sendReady(ready);
        if (cch.stage == null) {
            cch.start();
            cch.stage = (Stage) leaveButton.getScene().getWindow();
        }
    }

    public void toggleClass() {
        isBlizzard = !isBlizzard;
        ClientConnectionHandler.CurrentHandler.changeClass();
        if (isBlizzard) {
            classButton.setText("Blizzard");
        }
        else {
            classButton.setText("Richard");
        }

    }
}
