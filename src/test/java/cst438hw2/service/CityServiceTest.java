package cst438hw2.service;


import cst438hw2.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class CityServiceTest {

    @MockBean
    private CityRepository mockCityRepository;

    @MockBean
    private CountryRepository mockCountryRepository;

    @MockBean
    private WeatherService mockWeatherService;





    @BeforeEach
    public void setUpEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() throws Exception {

        Country country = new Country("TST", "Test_Country");
        City city = new City(1, "TestCity", "District_Test", 100000, country.getName());
        TempAndTime testTempAndTime= new TempAndTime(88, 1620783714, -14400);
        CityInfo cityTest = new CityInfo(1, "TestCity", "TST", country.getName(), "District_Test", 100000,  testTempAndTime );


        given(mockWeatherService.getTempAndTime("Test")).willReturn(new TempAndTime(88, 1620783714, -14400));
        given(mockCityRepository.findByName("Test")).willReturn(city, city);
        given(mockCountryRepository.findByCode("TST")).willReturn(country);

        CityService cityService = new CityService(mockCityRepository, mockCountryRepository, mockWeatherService);

        CityInfo test = cityService.getCityInfo("Test");

        assertEquals(test, cityTest);


    }


}


