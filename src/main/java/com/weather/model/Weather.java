package com.weather.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name = "weather")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class Weather {
  @Id
  String cep;
  String region;
  String neighborhood;
  String situation;
  @Enumerated
  AlertType alertType;
}
