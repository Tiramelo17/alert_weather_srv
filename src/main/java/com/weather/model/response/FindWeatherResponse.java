package com.weather.model.response;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.weather.model.AlertType;

import lombok.Builder;

@Builder(toBuilder = true)
@ResponseStatus(code = org.springframework.http.HttpStatus.OK)
public record FindWeatherResponse(
  String region,
  String neighborhood,
  String situation,
  AlertType alertType) {

}
