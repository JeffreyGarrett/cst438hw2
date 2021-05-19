package cst438hw2.service;


import cst438hw2.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class CityServiceTest {

    @MockBean
    private CityRepository mockCityRepository;

    @MockBean
    private CountryRepository mockCountryRepository;

    @MockBean
    private WeatherService mockWeatherService;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @MockBean
    private FanoutExchange fanout;

    @BeforeEach
    public void setUpEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() throws Exception {

        TempAndTime timeAndTemp = new TempAndTime(7.0, "3:00PM", 3);
        CityInfo cityInfo = new CityInfo(1,"TestCity","Test Country","TEST","DistrictTest",
                100000,timeAndTemp);
        Country country = new Country("Test Country","TST");
        City city = new City(1,"TestCity","DistrictTest", 100000, country);
        List<City> cities = new ArrayList<City>();
        cities.add(city);

        given(mockWeatherService.getTimeAndTemp("Test")).willReturn(new TempAndTime(88, "3:00PM", -14400));
        given(mockCityRepository.findByName("Test")).willReturn((List<City>) cities);
        given(mockCountryRepository.findByCode("TST")).willReturn(country);

        CityService cityService = new CityService(mockCityRepository, mockCountryRepository, mockWeatherService);

        CityInfo test = cityService.getCityInfo("Test");

        assertThat(test == cityInfo);


    }

    @Test
    public void rabbitMQTest() throws Exception{



    }




}


