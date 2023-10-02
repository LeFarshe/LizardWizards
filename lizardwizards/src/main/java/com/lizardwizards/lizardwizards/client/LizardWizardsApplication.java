package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Utils;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class LizardWizardsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setOnCloseRequest(e -> {e.consume(); Utils.closeProgram(stage);});
        stage.setTitle("Lizard Wizards");
        Utils.changeScene(stage, 0);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}