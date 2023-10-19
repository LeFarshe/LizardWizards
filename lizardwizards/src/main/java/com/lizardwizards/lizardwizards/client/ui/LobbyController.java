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
    private boolean ready = false;


    @FXML
    protected void onLeaveClick() {
        ClientUtils.changeScene((Stage) leaveButton.getScene().getWindow(), 0);
    }

    public void toggleReady(ActionEvent actionEvent) {
        ready = !ready;
        ClientConnectionHandler.CurrentHandler.sendReady(ready);
        if (ClientConnectionHandler.CurrentHandler.stage == null) {
            ClientConnectionHandler.CurrentHandler.start();
            ClientConnectionHandler.CurrentHandler.stage = (Stage) leaveButton.getScene().getWindow();
        }
    }
}
