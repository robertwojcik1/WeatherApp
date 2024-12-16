package org.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WeatherApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        WeatherManager weatherManager = new WeatherManager();
        String data = weatherManager.getWeatherData("warsaw");
        System.out.println(data);
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApplication.class.getResource("main-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Weather App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}