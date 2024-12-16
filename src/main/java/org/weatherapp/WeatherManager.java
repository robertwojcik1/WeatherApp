package org.weatherapp;

import org.weatherapp.model.service.FetchDataService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WeatherManager {

    private FetchDataService fetchDataService = new FetchDataService();

    private String getApiKey() {
        Properties properties = new Properties();
        String apiKey = "";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("Nie można znaleźć pliku config.properties");
                return "";
            }
            properties.load(input);
            apiKey = properties.getProperty("API_KEY");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return apiKey;
    }

    public String getWeatherData(String city) throws IOException, InterruptedException {
        String apiKey = getApiKey();
        String body = fetchDataService.getRawWeatherData(city, apiKey);
        return body;
    }

}
