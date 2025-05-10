package com.weather.model.request;

import lombok.Builder;

@Builder(toBuilder = true)
public record FindWeatherRequest(String x, String y) {
}
