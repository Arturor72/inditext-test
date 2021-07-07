package com.globant.inditextest.meteorologic.application.save;

import com.globant.inditextest.meteorologic.domain.Location;
import com.globant.inditextest.meteorologic.domain.Meteorologic;
import com.globant.inditextest.meteorologic.infraestructure.entity.LocationEntity;
import com.globant.inditextest.meteorologic.infraestructure.entity.MeteorologicalDataEntity;
import com.globant.inditextest.meteorologic.infraestructure.repository.MeteorologicalDataRepository;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SaveWeatherServiceImpl implements SaveWeatherService{

  private MeteorologicalDataRepository meteorologicalDataRepository;

  public SaveWeatherServiceImpl(MeteorologicalDataRepository meteorologicalDataRepository){
    this.meteorologicalDataRepository=meteorologicalDataRepository;

  }
  @Override
  public void saveWeather(Meteorologic meteorologic) {
    meteorologicalDataRepository.save(mapMeterologicDomainToEntity(meteorologic));
  }

  private MeteorologicalDataEntity mapMeterologicDomainToEntity(Meteorologic meteorologic){
    MeteorologicalDataEntity meteorologicalDataEntity=new MeteorologicalDataEntity();
    meteorologicalDataEntity.setId(meteorologic.getId());
    meteorologicalDataEntity.setDate(meteorologic.getDate());
    meteorologicalDataEntity.setTemperature(meteorologic.getTemperature());
    meteorologicalDataEntity.setLocationEntity(mapLocationDomainToEntity(meteorologic.getLocation(),meteorologicalDataEntity));
    return meteorologicalDataEntity;
  }

  private LocationEntity mapLocationDomainToEntity(Location location, MeteorologicalDataEntity meteorologicalDataEntity){
    LocationEntity locationEntity=new LocationEntity();
    locationEntity.setLat(location.getLat());
    locationEntity.setLon(location.getLon());
    locationEntity.setCity(location.getCity());
    locationEntity.setState(location.getState());
    locationEntity.setMeteorologicalDataEntity(meteorologicalDataEntity);
    return locationEntity;
  }
}
