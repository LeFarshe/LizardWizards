module com.lizardwizards.lizardwizards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    exports com.lizardwizards.lizardwizards.core;
    opens com.lizardwizards.lizardwizards.core to javafx.fxml;
    exports com.lizardwizards.lizardwizards.client;
    opens com.lizardwizards.lizardwizards.client to javafx.fxml;
    exports com.lizardwizards.lizardwizards.server;
    opens com.lizardwizards.lizardwizards.server to javafx.fxml;
    exports com.lizardwizards.lizardwizards.core.communication;
    opens com.lizardwizards.lizardwizards.core.communication to javafx.fxml;
    exports com.lizardwizards.lizardwizards.core.gameplay;
    opens com.lizardwizards.lizardwizards.core.gameplay to javafx.fxml;
    exports com.lizardwizards.lizardwizards.client.ui;
    opens com.lizardwizards.lizardwizards.client.ui to javafx.fxml;
    exports com.lizardwizards.lizardwizards.client.ui.modals;
    opens com.lizardwizards.lizardwizards.client.ui.modals to javafx.fxml;
    exports com.lizardwizards.lizardwizards.core.gameplay.weapons;
    opens com.lizardwizards.lizardwizards.core.gameplay.weapons to javafx.fxml;
    exports com.lizardwizards.lizardwizards.core.gameplay.collision;
    opens com.lizardwizards.lizardwizards.core.gameplay.collision to javafx.fxml;
    exports com.lizardwizards.lizardwizards.core.gameplay.levels;
    opens com.lizardwizards.lizardwizards.core.gameplay.levels to javafx.fxml;
    exports com.lizardwizards.lizardwizards.core.gameplay.enemies;
    opens com.lizardwizards.lizardwizards.core.gameplay.enemies to javafx.fxml;
}