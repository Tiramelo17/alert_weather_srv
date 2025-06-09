package com.weather.model.response;

import java.util.List;

import com.weather.model.WarnType;
import lombok.Builder;

@Builder(toBuilder = true)
public record GetReasonListResponse(List<ReasonResponse> reasonsList) {

  @Builder(toBuilder = true)
  public record ReasonResponse(
      String name,
      String description,
      String address,
      WarnType warnType) {
  }
}
