package com.globant.inditextest.meteorologic.application.delete;

import com.globant.inditextest.meteorologic.infraestructure.repository.MeteorologicalDataRepository;
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
