package com.lizardwizards.lizardwizards;

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
    public Label p2;
    @FXML
    public Button p2Button;
    @FXML
    public Button leaveButton;

    @FXML
    protected void onLeaveClick() {
        Utils.changeScene((Stage) leaveButton.getScene().getWindow(), 0);
    }
}
