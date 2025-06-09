package com.weather.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import com.weather.model.Reason;
import com.weather.model.TrendType;
import com.weather.model.response.TrendWeatherResponse;
import org.springframework.stereotype.Service;
import com.weather.client.WeatherClient;
import com.weather.model.request.FindWeatherRequest;
import com.weather.model.response.FindWeatherResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {

  private final WeatherClient weatherClient;
  private final ReasonService reasonService;

  public FindWeatherResponse getWeather(FindWeatherRequest request) {
    try {
      return Optional.of(weatherClient.findWeatherByCep(request.x(), request.y()))
          .get().getBody();
    } catch (Exception e) {
      throw new RuntimeException("Error fetching weather data", e);
    }
  }

  public TrendWeatherResponse getWeatherTrend() {
    try {
      return Optional.of(reasonService.findReasonToTrend())
        .map(this::groupReasonsByHour)
        .map(this::countReasonsPerHour)
        .map(trend -> this.discoveringTrends(trend)
          .toBuilder()
          .warningsPerHours(trend)
          .build()
        ).orElseGet(() -> TrendWeatherResponse.builder().build());
    } catch (Exception e) {
      throw new RuntimeException("Error in trend calc", e);
    }
  }

  private Map<LocalDateTime, List<Reason>> groupReasonsByHour(List<Reason> reasons) {
    return reasons.stream()
        .collect(Collectors.groupingBy(
            reason -> reason.getCreatedAt().truncatedTo(ChronoUnit.HOURS)
        ));
  }

  private Map<LocalDateTime, Long> countReasonsPerHour(Map<LocalDateTime, List<Reason>> reasonsGroupedByHour) {
    return reasonsGroupedByHour.entrySet().stream()
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            entry -> (long) entry.getValue().size()
        ));
  }

  private TrendWeatherResponse discoveringTrends(Map<LocalDateTime, Long> trendResponse) {
    AtomicInteger size = new AtomicInteger(0);
    TrendType trend = TrendType.DECREASING_RISK;

    for (Long t : trendResponse.values()) {
      if (t > size.get()) {
        size.set(t.intValue());
        trend = TrendType.INCREASING_RISK;
      } else {
        trend = TrendType.DECREASING_RISK;
      }
    }

    return TrendWeatherResponse.builder()
      .trend(trend)
      .build();
  }
}
