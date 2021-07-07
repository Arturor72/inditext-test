package com.globant.inditextest.weather.application.save;

import com.globant.inditextest.weather.domain.Location;
import com.globant.inditextest.weather.domain.Meteorologic;
import com.globant.inditextest.weather.infraestructure.entity.LocationEntity;
import com.globant.inditextest.weather.infraestructure.entity.MeteorologicalDataEntity;
import com.globant.inditextest.weather.infraestructure.repository.MeteorologicalDataRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

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

  @Override
  public boolean existsWeather(Long id) {
    return  meteorologicalDataRepository.existsById(id);
  }

  private MeteorologicalDataEntity mapMeterologicDomainToEntity(Meteorologic meteorologic){
    MeteorologicalDataEntity meteorologicalDataEntity=new MeteorologicalDataEntity();
    meteorologicalDataEntity.setId(meteorologic.getId());
    meteorologicalDataEntity.setDate(meteorologic.getDate());
    meteorologicalDataEntity.setTemperature(buildTemperatures(meteorologic.getTemperature()));
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
  private String buildTemperatures(List<Double> temperatures){
    return temperatures.stream().map(temperature -> String.valueOf(temperature)).reduce((s, s1)-> s+"|"+s1).orElse("");
  }
}
