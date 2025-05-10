package com.weather.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weather.model.response.FindWeatherResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WeatherClient {
  private final RestTemplate restTemplate;

  @Value("${weather.api.key}")
  private String API_KEY;

  public ResponseEntity<FindWeatherResponse> findWeatherByCep(String x, String y) {
    String url = String.format(
        "https://weather.googleapis.com/v1/currentConditions:lookup?key=%s&location.latitude=%s&location.longitude=%s",
        API_KEY, x, y);
    return restTemplate.getForEntity(url, FindWeatherResponse.class);
  }
}
