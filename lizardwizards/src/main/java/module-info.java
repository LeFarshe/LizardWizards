module com.lizardwizards.lizardwizards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.lizardwizards.lizardwizards to javafx.fxml;
    exports com.lizardwizards.lizardwizards;
}