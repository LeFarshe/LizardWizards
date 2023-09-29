package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Utils;
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
        Utils.changeScene((Stage) connect.getScene().getWindow(), 2);
    }

    @FXML
    protected void cancelConnection(){
        Utils.changeScene((Stage)connect.getScene().getWindow(), 0);
    }
}
