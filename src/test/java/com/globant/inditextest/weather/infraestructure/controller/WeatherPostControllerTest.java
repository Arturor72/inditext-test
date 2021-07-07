package com.globant.inditextest.weather.infraestructure.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.globant.inditextest.weather.application.delete.DeleteWeatherService;
import com.globant.inditextest.weather.domain.Location;
import com.globant.inditextest.weather.domain.Meteorologic;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WeatherPostControllerTest {

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
  public void saveWeather() throws JsonProcessingException {
    Location location=new Location(2L,12.3,12.4,"Del","Del" );
    List<Double> temperatures=new ArrayList<>();
    temperatures.add(13.4);
    temperatures.add(16.9);
    Meteorologic meteorologic=new Meteorologic(34L, LocalDate.now(), temperatures, location);
    ResponseEntity<Void> response=restTemplate.postForEntity(baseUrl,  meteorologic, Void.class);
    Assertions.assertTrue(response.getStatusCode()== HttpStatus.CREATED);
  }

}