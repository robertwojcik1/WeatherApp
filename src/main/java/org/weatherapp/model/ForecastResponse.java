package org.weatherapp.model;

import java.util.List;

public class ForecastResponse {
    public List<ForecastItem> list;
    public CityData city;


    @Override
    public String toString() {
        return "ForecastResponse{" +
                "list=" + list +
                ", cityData=" + city +
                '}';
    }
}
