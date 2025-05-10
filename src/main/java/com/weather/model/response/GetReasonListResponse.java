package com.weather.model.response;

import java.util.List;

import lombok.Builder;

@Builder(toBuilder = true)
public record GetReasonListResponse(List<ReasonResponse> reasonsList) {

  @Builder(toBuilder = true)
  public record ReasonResponse(
      String name,
      String description) {
  }
}
