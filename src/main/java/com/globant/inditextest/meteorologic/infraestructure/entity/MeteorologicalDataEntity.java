package com.globant.inditextest.meteorologic.infraestructure.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meteorological_data")
public class MeteorologicalDataEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "date")
  private LocalDate date;
  @Column(name = "temperature")
  private Double temperature;

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

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
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
