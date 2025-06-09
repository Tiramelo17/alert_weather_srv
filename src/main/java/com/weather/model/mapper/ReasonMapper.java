package com.weather.model.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.weather.model.Reason;
import com.weather.model.request.ReasonRequest;
import com.weather.model.response.GetReasonListResponse.ReasonResponse;

@Mapper(componentModel = "spring")
public interface ReasonMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
  Reason mapToReason(ReasonRequest reasonRequest);

  ReasonResponse mapToReasonResponse(Reason reason);

  List<ReasonResponse> mapToReasonResponseList(List<Reason> reasons);

}
