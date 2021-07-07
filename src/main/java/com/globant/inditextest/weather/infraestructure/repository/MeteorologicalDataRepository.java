package com.globant.inditextest.weather.infraestructure.repository;

import com.globant.inditextest.weather.infraestructure.entity.MeteorologicalDataEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeteorologicalDataRepository extends
    JpaRepository<MeteorologicalDataEntity, Long> {

  List<MeteorologicalDataEntity> findByDate(LocalDate date);
}
