package com.weather.schedules;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.weather.service.ReasonService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReasonSchedule {

  private final ReasonService reasonService;

  @Scheduled(cron = "0 0 0/12 * * ?")
  public void deletReasons() {
    reasonService.deleteReasonOutOfTime();
  }

  @PostConstruct
  public void runOnStartup() {
    reasonService.deleteReasonOutOfTime();
  }
}
