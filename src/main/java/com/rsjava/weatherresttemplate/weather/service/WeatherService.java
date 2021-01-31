package com.rsjava.weatherresttemplate.weather.service;

import com.rsjava.weatherresttemplate.weather.mapper.WeatherMapper;
import com.rsjava.weatherresttemplate.weather.request.WeatherRequest;
import com.rsjava.weatherresttemplate.weather.response.WeatherResponse;
import com.rsjava.weatherresttemplate.weather.webclient.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.rsjava.weatherresttemplate.weather.mapper.WeatherMapper.mapToResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherResponse getActualWeatherDetailsForCity(String city) {

        WeatherRequest weatherRequest = weatherClient.getWeatherRequest(city);
        if (weatherRequest == null){
            throw new RuntimeException("Something wrong :)");
        }
        return mapToResponse(weatherRequest);
    }
}
