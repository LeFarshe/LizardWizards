package com.lizardwizards.lizardwizards;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LizardWizardsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setOnCloseRequest(e -> {e.consume(); Utils.closeProgram(stage);});
        stage.setTitle("LizardWizards");
        Utils.changeScene(stage, 0);
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}