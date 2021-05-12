package cst438hw2.controller;

import cst438hw2.domain.*;
import cst438hw2.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(CityRestController.class)
public class CityRestControllerTest {
    @MockBean
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @InjectMocks
    private CityRestController cityRestController;

    @SuppressWarnings("deprecation")

    @BeforeEach
    public void setUpEach() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetWeather() throws Exception {
        //Setup - Arrange
        TempAndTime timeAndTemp = new TempAndTime(7.0, 10000, 3);
        CityInfo cityInfo = new CityInfo(1,"TestCity","Test Country","TEST","DistrictTest",
                100000,timeAndTemp);
        Mockito.when(cityService.getCityInfo("TestCity")).thenReturn(cityInfo);
        Country country = new Country("Test Country","TST");
        City city = new City(1,"TestCity","DistrictTest", 100000, country);
        List<City> cities = new ArrayList<City>();
        cities.add(city);
        Mockito.when(cityRepository.findByName("TestCity")).thenReturn(cities);
        //Call - Act
        ResponseEntity<CityInfo> response = cityRestController.getWeather("TestCity");
        //Check - Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getBody()).isEqualTo(cityInfo);
        //GETMAPPING NOT TESTED
        //MockHttpServletResponse response = mvc.perform(get("/city/TestCity")).andReturn().getResponse();
    }
}


