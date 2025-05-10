package com.weather.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.weather.model.Reason;

import jakarta.transaction.Transactional;

public interface ReasonRepository extends JpaRepository<Reason, Long> {

  @Transactional
  @Modifying
  @Query("DELETE FROM reason r WHERE r.createdAt < :cutoffDate")
  int deleteReasonOutOfTime(Date cutoffDate);
}
