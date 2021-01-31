package com.rsjava.weatherresttemplate.weather.request;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class WeatherRequest {
    private List<DescriptionRequest> weather = new ArrayList<>();
    private TemperatureRequest main;
    private int visibility;
    private WindRequest wind;
    private WeatherDetailsRequest sys;
    private String name;
}
