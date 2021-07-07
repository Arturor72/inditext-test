package com.globant.inditextest.weather.infraestructure.controller;

import com.globant.inditextest.weather.application.get.GetWeatherService;
import com.globant.inditextest.weather.domain.Meteorologic;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherGetController {

  private GetWeatherService  getWeatherService;

  public WeatherGetController(GetWeatherService getWeatherService){
   this.getWeatherService=getWeatherService;
  }

  @GetMapping("/weather")
  public ResponseEntity<Set<Meteorologic>> getAllWeatherByDate(@RequestParam(required = false) String date){
    if(date==null){
      return new ResponseEntity<>(getWeatherService.getAllMeteorologic(), HttpStatus.OK);
    }else{
      return new ResponseEntity<>(getWeatherService.getMeteorologiucByDate(date), HttpStatus.OK);
    }
  }
}
