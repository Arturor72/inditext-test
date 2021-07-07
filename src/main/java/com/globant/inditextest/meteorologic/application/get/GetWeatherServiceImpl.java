package com.globant.inditextest.meteorologic.application.get;

import com.globant.inditextest.meteorologic.domain.Location;
import com.globant.inditextest.meteorologic.domain.Meteorologic;
import com.globant.inditextest.meteorologic.infraestructure.entity.LocationEntity;
import com.globant.inditextest.meteorologic.infraestructure.entity.MeteorologicalDataEntity;
import com.globant.inditextest.meteorologic.infraestructure.repository.MeteorologicalDataRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class GetWeatherServiceImpl implements GetWeatherService {

  private MeteorologicalDataRepository meteorologicalDataRepository;

  public GetWeatherServiceImpl(MeteorologicalDataRepository meteorologicalDataRepository) {
    this.meteorologicalDataRepository = meteorologicalDataRepository;
  }

  @Override
  public Set<Meteorologic> getAllMeteorologic() {
    List<MeteorologicalDataEntity> meteorologicalDataEntityList = meteorologicalDataRepository
        .findAll();
    return meteorologicalDataEntityList.stream()
        .map(meteorologicalDataEntity -> mapEntityToDomain(meteorologicalDataEntity)).collect(
            Collectors.toSet());
  }

  @Override
  public Set<Meteorologic> getMeteorologiucByDate(String date) {

    List<MeteorologicalDataEntity> meteorologicalDataEntityList = meteorologicalDataRepository
        .findByDate(LocalDate.parse(date));
    return meteorologicalDataEntityList.stream()
        .map(meteorologicalDataEntity -> mapEntityToDomain(meteorologicalDataEntity)).collect(
            Collectors.toSet());
  }

  private Meteorologic mapEntityToDomain(MeteorologicalDataEntity meteorologicalEntity) {
    return new Meteorologic(meteorologicalEntity.getId(), meteorologicalEntity.getDate(),
        meteorologicalEntity.getTemperature(),
        mapLocationEntityToDomain(meteorologicalEntity.getLocationEntity()));
  }

  private Location mapLocationEntityToDomain(LocationEntity locationEntity) {
    return new Location(locationEntity.getId(), locationEntity.getLat(), locationEntity.getLon(),
        locationEntity.getCity(), locationEntity.getState());
  }
}
