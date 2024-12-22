package org.weatherapp.model;

public class WeatherData {
    public int id;
//    overall condition(Rain, Clouds etc)
    public String main;
    public String description;
    public String icon;

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
