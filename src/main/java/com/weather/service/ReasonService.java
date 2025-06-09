package com.weather.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.weather.model.Reason;
import com.weather.model.mapper.ReasonMapper;
import com.weather.model.request.ReasonRequest;
import com.weather.model.response.GetReasonListResponse;
import com.weather.repository.ReasonRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReasonService {

  private final ReasonRepository reasonRepository;
  private final ReasonMapper mapper;

  public void createNewReason(ReasonRequest request) {
    Reason reason = mapper.mapToReason(request);
    reasonRepository.save(reason);
  }

  public GetReasonListResponse findReasons() {
    List<Reason> reasons = reasonRepository.findAll();
    return GetReasonListResponse.builder().reasonsList(
        mapper.mapToReasonResponseList(reasons))
        .build();
  }

  public void deleteReasonOutOfTime() {
    reasonRepository.deleteReasonOutOfTime(LocalDateTime.now().minusHours(12));
  }

  public List<Reason> findReasonToTrend(){
    return reasonRepository.findReasonToTrend(LocalDateTime.now().minusHours(4));
  }

}
