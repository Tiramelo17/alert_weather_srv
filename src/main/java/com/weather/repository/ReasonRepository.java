package com.weather.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.weather.model.Reason;
import jakarta.transaction.Transactional;

public interface ReasonRepository extends JpaRepository<Reason, Long> {

  @Transactional
  @Modifying
  @Query("DELETE FROM reason r WHERE r.createdAt < :limitDate")
  int deleteReasonOutOfTime(LocalDateTime limitDate);

  @Query("SELECT r FROM reason r WHERE r.createdAt >= :limitHours")
  List<Reason> findReasonToTrend(LocalDateTime limitHours);
}
