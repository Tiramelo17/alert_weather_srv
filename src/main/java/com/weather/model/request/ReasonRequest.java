package com.weather.model.request;

import com.weather.model.WarnType;

public record ReasonRequest(
    String name,
    String description,
    String address,
    WarnType warnType) {
}
