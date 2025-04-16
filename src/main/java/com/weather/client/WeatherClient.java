package com.weather.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weather.model.response.FindWeatherResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WeatherClient {
  private final RestTemplate restTemplate;

  public String findWeatherByCep(String cep) {
    restTemplate.getForEntity("https://localhost/teste", String.class);
    return "";// FindWeatherResponse.builder().build();
  }
}
