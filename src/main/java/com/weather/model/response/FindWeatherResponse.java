package com.weather.model.response;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Builder;

@Builder(toBuilder = true)
@ResponseStatus(code = org.springframework.http.HttpStatus.OK)
public record FindWeatherResponse(
    String currentTime,
    TimeZone timeZone,
    boolean isDaytime,
    WeatherCondition weatherCondition,
    Temperature temperature,
    Temperature feelsLikeTemperature,
    Temperature dewPoint,
    Temperature heatIndex,
    Temperature windChill,
    int relativeHumidity,
    int uvIndex,
    Precipitation precipitation,
    int thunderstormProbability,
    AirPressure airPressure,
    Wind wind,
    Visibility visibility,
    int cloudCover,
    CurrentConditionsHistory currentConditionsHistory) {

  public record TimeZone(
      String id) {
  }

  public record WeatherCondition(
      String iconBaseUri,
      Description description,
      String type) {
    public record Description(
        String text,
        String languageCode) {
    }
  }

  public record Temperature(
      double degrees,
      String unit) {
  }

  public record Precipitation(
      Probability probability,
      SnowQpf snowQpf,
      Qpf qpf) {
    public record Probability(
        int percent,
        String type) {
    }

    public record SnowQpf(
        double quantity,
        String unit) {
    }

    public record Qpf(
        double quantity,
        String unit) {
    }
  }

  public record AirPressure(
      double meanSeaLevelMillibars) {
  }

  public record Wind(
      Direction direction,
      Speed speed,
      Gust gust) {
    public record Direction(
        int degrees,
        String cardinal) {
    }

    public record Speed(
        double value,
        String unit) {
    }

    public record Gust(
        double value,
        String unit) {
    }
  }

  public record Visibility(
      double distance,
      String unit) {
  }

  public record CurrentConditionsHistory(
      TemperatureChange temperatureChange,
      Temperature maxTemperature,
      Temperature minTemperature,
      SnowQpf snowQpf,
      Qpf qpf) {
    public record TemperatureChange(
        double degrees,
        String unit) {
    }

    public record SnowQpf(
        double quantity,
        String unit) {
    }

    public record Qpf(
        double quantity,
        String unit) {
    }
  }
}
