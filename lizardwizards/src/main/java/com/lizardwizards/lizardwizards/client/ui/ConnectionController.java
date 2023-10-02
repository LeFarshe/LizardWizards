package com.lizardwizards.lizardwizards.client.ui;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectionController {
    @FXML
    Button connect;
    @FXML
    Button cancel;
    @FXML
    TextField ip;

    @FXML
    protected void connectToSession(){
        ClientUtils.changeScene((Stage) connect.getScene().getWindow(), 2);
    }

    @FXML
    protected void cancelConnection(){
        ClientUtils.changeScene((Stage)connect.getScene().getWindow(), 0);
    }
}
