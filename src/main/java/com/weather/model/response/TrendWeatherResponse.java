package com.weather.model.response;

import com.weather.model.TrendType;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.Map;

@Builder(toBuilder = true)
public record TrendWeatherResponse(Map<LocalDateTime, Long> warningsPerHours, TrendType trend) {
}
