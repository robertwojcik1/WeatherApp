package org.weatherapp.model;

import java.util.List;

public class ForecastItem {
//    time of forecast
    public long dt;
    public MainData main;
    public List<WeatherData> weather;
    public CloudsData clouds;
    public WindData wind;
    public int visibility;
    public double pop;
    public RainData rain;
    public SysData sys;
    public String dt_txt;

    @Override
    public String toString() {
        return "ForecastItem{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", visibility=" + visibility +
                ", pop=" + pop +
                ", rain=" + rain +
                ", sys=" + sys +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}
