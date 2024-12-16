module org.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.net.http;

    opens org.weatherapp to javafx.fxml;
    exports org.weatherapp;
    exports org.weatherapp.controller;
    opens org.weatherapp.controller to javafx.fxml;
}