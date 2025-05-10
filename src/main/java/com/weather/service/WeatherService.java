package com.weather.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.weather.client.WeatherClient;
import com.weather.model.request.FindWeatherRequest;
import com.weather.model.response.FindWeatherResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {

  private final WeatherClient weatherClient;

  public FindWeatherResponse getWeather(FindWeatherRequest request) {
    try {
      return Optional.of(weatherClient.findWeatherByCep(request.x(), request.y()))
          .get().getBody();
    } catch (Exception e) {
      throw new RuntimeException("Error fetching weather data", e);
    }
  }
}
