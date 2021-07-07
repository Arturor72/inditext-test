package com.globant.inditextest.weather.infraestructure.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globant.inditextest.weather.domain.Meteorologic;
import jdk.nashorn.internal.parser.JSONParser;
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
    ResponseEntity<String> response =
        restTemplate.getForEntity(
            baseUrl,
            String.class);
    System.out.println(response.getBody());
  }
}