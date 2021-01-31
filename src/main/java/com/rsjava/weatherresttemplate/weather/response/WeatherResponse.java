package com.rsjava.weatherresttemplate.weather.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class WeatherResponse {
    private final String country;
    private final String city;
    private final double temperature;
    private final double perceivedTemperature;
    private final String description;
    private final int pressure;
    private final int visibility;
    private final double windSpeed;
    private final String sunrise;
    private final String sunset;
}
