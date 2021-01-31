package com.rsjava.weatherresttemplate.weather.webclient;

import com.rsjava.weatherresttemplate.weather.request.WeatherRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class WeatherClient {

    @Value("${weather.units}")
    private String units;

    @Value("${weather.language}")
    private String language;

    @Value("${weather.api-key}")
    private String apiKey;

    @Value("${weather.url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    public WeatherRequest getWeatherRequest(@PathVariable String city) {
        WeatherRequest request = null;

        try {
            request = restTemplate.getForObject(getPath(city), WeatherRequest.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Byku nie ma takiego miasta");
        }

        log.info(request.toString());
        return request;
    }

    private String getPath(@PathVariable String city) {
        return url
                    + "weather?q="
                    + city
                    + ",pl&appid="
                    + apiKey
                    + "&lang="
                    + language
                    + "&units="
                    + units;
    }
}
