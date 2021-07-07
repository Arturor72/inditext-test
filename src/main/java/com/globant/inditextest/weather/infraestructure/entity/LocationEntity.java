package com.globant.inditextest.weather.infraestructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class LocationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "lat")
  private Double lat;
  @Column(name = "lon")
  private Double lon;
  @Column(name = "city")
  private String city;
  @Column(name = "state")
  private String state;
  @ManyToOne
  @JoinColumn(name = "id_met_data")
  private MeteorologicalDataEntity meteorologicalDataEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public MeteorologicalDataEntity getMeteorologicalDataEntity() {
    return meteorologicalDataEntity;
  }

  public void setMeteorologicalDataEntity(
      MeteorologicalDataEntity meteorologicalDataEntity) {
    this.meteorologicalDataEntity = meteorologicalDataEntity;
  }
}
