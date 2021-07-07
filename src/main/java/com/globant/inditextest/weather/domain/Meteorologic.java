package com.globant.inditextest.meteorologic.domain;

import java.time.LocalDate;

public final class Meteorologic {

  private Long id;
  private LocalDate date;
  private Double temperature;
  private Location location;

  public Meteorologic(Long id, LocalDate date, Double temperature, Location location) {
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

  public Double getTemperature() {
    return temperature;
  }

  public Location getLocation() {
    return location;
  }
}
