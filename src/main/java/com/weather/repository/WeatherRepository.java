package com.weather.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.weather.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, String> {
  Optional<Weather> findByCep(String cep);
}
