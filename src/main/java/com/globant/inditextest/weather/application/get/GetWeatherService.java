package com.globant.inditextest.weather.application.get;


import com.globant.inditextest.weather.domain.Meteorologic;
import java.util.Optional;
import java.util.Set;

public interface GetWeatherService {

  public Set<Meteorologic> getAllMeteorologic();

  public Set<Meteorologic> getMeteorologiucByDate(String date);

  public Meteorologic  getMeteologicById(Long id);

}
