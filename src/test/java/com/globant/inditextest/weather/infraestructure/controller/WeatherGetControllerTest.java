package com.globant.inditextest.weather.infraestructure.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WeatherGetControllerTest {

  @LocalServerPort
  private int port;

  private String baseUrl = "http://localhost";

  private static RestTemplate restTemplate = null;


  @BeforeAll
  public static void init() {
    restTemplate = new RestTemplate();
  }

  @BeforeEach
  public void setUp() {
    baseUrl = baseUrl.concat(":").concat(port + "").concat("/weather");
  }

  @Test
  public void getAllWeather() throws JsonProcessingException {
    ResponseEntity<Object[]> response =
        restTemplate.getForEntity(
            baseUrl,
            Object[].class);
    Assertions.assertTrue(response.getBody().length == 5);
  }

  @Test
  public void getAllWeatherByDate() throws JsonProcessingException {
    String date = "2021-07-10";
    ResponseEntity<Object[]> response =
        restTemplate.getForEntity(
            baseUrl.concat("?date=").concat(date),
            Object[].class);
    Assertions.assertTrue(response.getBody().length == 1);
  }
}