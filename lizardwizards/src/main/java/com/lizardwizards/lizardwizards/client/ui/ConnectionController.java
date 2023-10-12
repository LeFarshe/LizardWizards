package com.lizardwizards.lizardwizards.client.ui;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.client.ClientUtils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnectionController {
    @FXML
    Button connect;
    @FXML
    Button cancel;
    @FXML
    TextField ip;

    @FXML
    protected void connectToSession(){
        var address = ip.getText().split(":");
        String ipAddress = address[0];
        String port = address[1];
        try {
            new ClientConnectionHandler(ipAddress, Integer.parseInt(port));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ClientUtils.changeScene((Stage) connect.getScene().getWindow(), 2);
    }

    @FXML
    protected void cancelConnection(){
        ClientUtils.changeScene((Stage)connect.getScene().getWindow(), 0);
    }
}
