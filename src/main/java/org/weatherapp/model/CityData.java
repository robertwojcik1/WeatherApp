package org.weatherapp.model;

public class CityData {
    public String name;
    public String country;
    public int timezone;
//    Unix, UTC
    public long sunrise;
    public long sunset;

    @Override
    public String toString() {
        return "CityData{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", timezone=" + timezone +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
