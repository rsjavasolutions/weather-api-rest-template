package com.rsjava.weatherresttemplate.weather.request;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TemperatureRequest {
    private float temp;
    private float feels_like;
    private int pressure;
    private int humidity;

}
