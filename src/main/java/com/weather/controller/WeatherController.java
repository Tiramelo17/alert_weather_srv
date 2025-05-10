package com.weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.weather.model.request.FindWeatherRequest;
import com.weather.model.response.FindWeatherResponse;
import com.weather.service.WeatherService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
  private final WeatherService weatherService;

  @GetMapping
  public FindWeatherResponse getMethodName(@RequestBody FindWeatherRequest request) {
    return weatherService.getWeather(request);
  }
}
