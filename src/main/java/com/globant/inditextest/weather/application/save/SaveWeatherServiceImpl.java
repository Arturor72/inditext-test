package com.globant.inditextest.weather.application.save;

import com.globant.inditextest.weather.domain.Location;
import com.globant.inditextest.weather.domain.Meteorologic;
import com.globant.inditextest.weather.infraestructure.entity.LocationEntity;
import com.globant.inditextest.weather.infraestructure.entity.MeteorologicalDataEntity;
import com.globant.inditextest.weather.infraestructure.repository.MeteorologicalDataRepository;
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
