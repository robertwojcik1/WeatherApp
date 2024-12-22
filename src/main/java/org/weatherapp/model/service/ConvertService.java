package org.weatherapp.model.service;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class ConvertService {

    public OffsetDateTime getDateTimeFromUnixTimestamp(long unixTimestamp, int timezone) {
        int offsetHours = timezone / 3600;
        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(offsetHours));

        return offsetDateTime;
    }

    public String getWindDirection(int degree) {
        if (degree >= 337.5 || degree < 22.5) {
            return "N";
        } else if (degree >= 22.5 && degree < 67.5) {
            return "NE";
        } else if (degree >= 67.5 && degree < 112.5) {
            return "E";
        } else if (degree >= 112.5 && degree < 157.5) {
            return "SE";
        } else if (degree >= 157.5 && degree < 202.5) {
            return "S";
        } else if (degree >= 202.5 && degree < 247.5) {
            return "SW";
        } else if (degree >= 247.5 && degree < 292.5) {
            return "W";
        } else {
            return "NW";
        }
    }
}
