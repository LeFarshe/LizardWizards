package com.lizardwizards.lizardwizards.client;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class LizardWizardsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setOnCloseRequest(e -> {e.consume(); ClientUtils.closeProgram(stage);});
        stage.setTitle("Lizard Wizards");
        ClientUtils.changeScene(stage, 0);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}