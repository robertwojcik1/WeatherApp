package org.weatherapp.model;

public class WindData {
    public double speed;
    public int deg;
    public double gust;

    @Override
    public String toString() {
        return "WindData{" +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                '}';
    }
}
