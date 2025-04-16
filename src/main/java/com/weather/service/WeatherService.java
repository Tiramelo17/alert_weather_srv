package com.weather.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.weather.client.WeatherClient;
import com.weather.model.AlertType;
import com.weather.model.Weather;
import com.weather.model.request.FindWeatherRequest;
import com.weather.model.response.FindWeatherResponse;
import com.weather.repository.WeatherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {

  private final WeatherRepository repository;
  private final WeatherClient weatherClient;

  public FindWeatherResponse getWeather(FindWeatherRequest request) {
    try {
      return repository.findByCep(request.cep())
          .map(weather -> FindWeatherResponse.builder()
              .region(weather.getRegion())
              .neighborhood(weather.getNeighborhood())
              .situation(weather.getSituation())
              .alertType(weather.getAlertType())
              .build())
          .orElse(Optional.of(weatherClient.findWeatherByCep(request.cep()))
              .map(t -> FindWeatherResponse.builder()
                  .build())
              .get());
    } catch (Exception e) {
      throw new RuntimeException("Error fetching weather data", e);
    }
  }

  public void createWeather() {
    repository.save(Weather.builder().cep("32183280")
        .region("Nacional")
        .neighborhood("Pedra Azul")
        .situation("situation")
        .alertType(AlertType.FLOODING)
        .build());
  }
}
