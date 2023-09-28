package com.lizardwizards.lizardwizards;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean result;

    public static boolean display (String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);
        Label label = new Label(message);

        Button yes = new Button("Yes");
        Button no = new Button("No");
        yes.setOnAction(e -> {
            result = true;
            window.close();
        });
        no.setOnAction(e -> {
            result = false;
            window.close();
        });
        VBox layout = new VBox(10);
        HBox buttons = new HBox(30);
        buttons.getChildren().addAll(yes, no);
        buttons.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, buttons);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return result;
    }
}
