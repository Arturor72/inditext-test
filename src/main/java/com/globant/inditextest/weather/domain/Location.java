package com.globant.inditextest.weather.domain;

public final class Location {

  private Long id;
  private Double lat;
  private Double lon;
  private String city;
  private String state;

  public Location(Long id, Double lat, Double lon, String city,
      String state) {
    this.id = id;
    this.lat = lat;
    this.lon = lon;
    this.city = city;
    this.state = state;
  }

  public Long getId() {
    return id;
  }

  public Double getLat() {
    return lat;
  }

  public Double getLon() {
    return lon;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }
}
