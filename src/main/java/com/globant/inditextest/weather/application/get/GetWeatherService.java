package com.globant.inditextest.meteorologic.application.get;


import com.globant.inditextest.meteorologic.domain.Meteorologic;
import java.time.LocalDate;
import java.util.Set;

public interface GetWeatherService {

  public Set<Meteorologic> getAllMeteorologic();

  public Set<Meteorologic> getMeteorologiucByDate(String date);
}
