package org.weatherapp.model.service;

import com.google.gson.*;
import org.weatherapp.model.ForecastItem;
import org.weatherapp.model.ForecastResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.OffsetDateTime;
import java.util.Date;

public class FetchDataService {

    public FetchDataService(ConvertService convertService) {
        this.convertService = convertService;
    }

    private final ConvertService convertService;

    public HttpResponse<String> getRawWeatherData(String city, String apiKey) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/forecast?q=" +
                        city + "&appid=" + apiKey + "&units=metric"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    public String getWeatherData(String city, String apiKey) throws IOException, InterruptedException {
        HttpResponse<String> response = getRawWeatherData(city, apiKey);
        if (response.statusCode() == 200) {
            String rawData = response.body();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ForecastResponse forecastResponse = gson.fromJson(rawData, ForecastResponse.class);
            System.out.println(response.statusCode());
            OffsetDateTime sunset = convertService.getDateTimeFromUnixTimestamp(forecastResponse.city.sunset,
                    forecastResponse.city.timezone);
            String windDirection = convertService.getWindDirection(forecastResponse.list.getFirst().wind.deg);
            System.out.println("Wind direction: " + windDirection);
            System.out.println(forecastResponse.city);
            for (ForecastItem fi : forecastResponse.list) {
                System.out.println(fi);
            }

            return "";
        } else {
            System.out.println("Error: " + response.statusCode());
            return null;
        }
    }
}
