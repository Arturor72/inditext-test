package com.globant.inditextest.weather.infraestructure.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meteorological_data")
public class MeteorologicalDataEntity {

  @Id
  private Long id;
  @Column(name = "date")
  private LocalDate date;
  @Column(name = "temperature")
  private String temperature;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "meteorologicalDataEntity")
  private LocationEntity locationEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public LocationEntity getLocationEntity() {
    return locationEntity;
  }

  public void setLocationEntity(
      LocationEntity locationEntity) {
    this.locationEntity = locationEntity;
  }
}
