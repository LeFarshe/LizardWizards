module com.lizardwizards.lizardwizards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    exports com.lizardwizards.lizardwizards.core;
    opens com.lizardwizards.lizardwizards.core to javafx.fxml;
    exports com.lizardwizards.lizardwizards.client;
    opens com.lizardwizards.lizardwizards.client to javafx.fxml;
}