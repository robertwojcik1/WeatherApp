package org.weatherapp.model;

public class RainData {
//    Rain volume for last 3 hours (mm)
    public double _3h;

    @Override
    public String toString() {
        return "_3h=" + _3h +
                '}';
    }
}
