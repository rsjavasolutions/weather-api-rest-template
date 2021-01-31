package com.rsjava.weatherresttemplate.weather.mapper;

import com.rsjava.weatherresttemplate.weather.request.WeatherRequest;
import com.rsjava.weatherresttemplate.weather.response.WeatherResponse;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
                getDate(request.getSys().getSunset()),
                getDate(request.getSys().getSunrise())
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
        Date date = new Date((long) timeStamp * 1000);

        return DateTimeFormatter.ofPattern("HH:mm").format(convertToLocalDateTimeViaInstant(date));
    }

    private static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.of("Europe/Berlin"))
                .toLocalDateTime();
    }
}
