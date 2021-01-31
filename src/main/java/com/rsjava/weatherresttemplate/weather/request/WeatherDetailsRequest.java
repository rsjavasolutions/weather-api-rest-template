package com.rsjava.weatherresttemplate.weather.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WeatherDetailsRequest {
    private String country;
    private int sunrise;
    private int sunset;
}
