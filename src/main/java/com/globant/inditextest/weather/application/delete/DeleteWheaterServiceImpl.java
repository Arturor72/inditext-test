package com.globant.inditextest.weather.application.delete;

import com.globant.inditextest.weather.infraestructure.repository.MeteorologicalDataRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteWheaterServiceImpl implements DeleteWeatherService{

  private MeteorologicalDataRepository meteorologicalDataRepository;
  public  DeleteWheaterServiceImpl(MeteorologicalDataRepository meteorologicalDataRepository){
    this.meteorologicalDataRepository=meteorologicalDataRepository;
  }
  @Override
  public void deleteAllWeather() {
    meteorologicalDataRepository.deleteAll();
  }
}
