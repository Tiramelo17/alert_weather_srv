package com.weather.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name = "reason")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class Reason {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  String description;
  String address;

  @Enumerated(EnumType.STRING)
  WarnType warnType;

  @Builder.Default
  LocalDateTime createdAt = LocalDateTime.now();
}
