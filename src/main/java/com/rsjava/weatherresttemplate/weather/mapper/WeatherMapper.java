package com.rsjava.weatherresttemplate.weather.mapper;

import com.rsjava.weatherresttemplate.weather.request.WeatherRequest;
import com.rsjava.weatherresttemplate.weather.response.WeatherResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class WeatherMapper {

    public static WeatherResponse mapToResponse(WeatherRequest request) {
        return new WeatherResponse(
                getCountryFullName(request.getSys().getCountry()),
                request.getName(),
                getRoundedNumberToTwoDecimalPlaces(request.getMain().getTemp()),
                getRoundedNumberToTwoDecimalPlaces(request.getMain().getFeels_like()),
                request.getWeather().get(0).getDescription(),
                request.getMain().getPressure(),
                request.getVisibility(),
                getRoundedNumberToTwoDecimalPlaces(request.getWind().getSpeed()),
                getDate(request.getSys().getSunrise()),
                getDate(request.getSys().getSunset())
        );
    }

    private static double getRoundedNumberToTwoDecimalPlaces(double value) {
        value *= 100;
        value = Math.round(value);
        value /= 100;

        return value;
    }

    private static String getCountryFullName(String countryCode) {
        Locale locale = new Locale("", countryCode);

        return locale == null
                ? "Unknown Country"
                : locale.getDisplayCountry();
    }

    private static String getDate(int timeStamp) {
        return new SimpleDateFormat("HH:mm").format(new Date((long) timeStamp * 1000));
    }
}
