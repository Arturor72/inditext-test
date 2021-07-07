package com.globant.inditextest.meteorologic.infraestructure.controller;

import com.globant.inditextest.meteorologic.application.save.SaveWeatherService;
import com.globant.inditextest.meteorologic.domain.Meteorologic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherPostController {

  private SaveWeatherService saveWeatherService;

  public WeatherPostController(SaveWeatherService saveWeatherService){
    this.saveWeatherService=saveWeatherService;
  }
  @PostMapping("/weather")
  public ResponseEntity<Void> saveWeather(@RequestBody Meteorologic meteorologic){
    saveWeatherService.saveWeather(meteorologic);
    return  new ResponseEntity<>(HttpStatus.CREATED);
  }
}
