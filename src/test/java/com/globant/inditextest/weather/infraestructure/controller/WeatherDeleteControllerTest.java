package com.globant.inditextest.weather.infraestructure.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.globant.inditextest.weather.application.delete.DeleteWeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WeatherDeleteController.class)
class WeatherDeleteControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DeleteWeatherService deleteWeatherService;
  
  @Test
  void WhenDeleteALlrecord_thenReturn200() throws Exception {
    mockMvc.perform(delete("/weather")).andExpect(status().isOk());
  }

}