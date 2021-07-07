package com.globant.inditextest.weather.infraestructure.controller;

import com.globant.inditextest.weather.application.delete.DeleteWeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherDeleteController {

  private DeleteWeatherService deleteWeatherService;

  public WeatherDeleteController(DeleteWeatherService deleteWeatherService) {
    this.deleteWeatherService = deleteWeatherService;
  }

  @DeleteMapping("/weather")
  public ResponseEntity<Void> deleteAll() {
    deleteWeatherService.deleteAllWeather();
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
