package com.rsjava.weatherresttemplate.weather.controller;

import com.rsjava.weatherresttemplate.weather.service.WeatherService;
import com.rsjava.weatherresttemplate.weather.response.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("actual/{city}")
    public WeatherResponse getActualWeatherDetailsForCity(@PathVariable String city) {
        return weatherService.getActualWeatherDetailsForCity(city);
    }
}
