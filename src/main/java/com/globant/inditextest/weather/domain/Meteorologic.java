package com.globant.inditextest.weather.domain;

import java.time.LocalDate;
import java.util.List;

public final class Meteorologic {

  private Long id;
  private LocalDate date;
  private List<Double> temperature;
  private Location location;

  public Meteorologic(Long id, LocalDate date, List<Double> temperature, Location location) {
    this.id = id;
    this.date = date;
    this.temperature = temperature;
    this.location = location;
  }

  public Long getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public List<Double> getTemperature() {
    return temperature;
  }

  public Location getLocation() {
    return location;
  }
}
