package com.weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.model.request.ReasonRequest;
import com.weather.model.response.GetReasonListResponse;
import com.weather.service.ReasonService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("reason")
public class ReasonController {

  private final ReasonService service;

  @PostMapping
  public void createReason(@RequestBody ReasonRequest request) {
    service.createNewReason(request);
  }

  @GetMapping
  public GetReasonListResponse getAllReasons() {
    return service.findReassons();
  }

}
