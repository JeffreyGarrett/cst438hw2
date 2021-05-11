package cst438hw2.service;

import cst438hw2.domain.CityRepository;
import cst438hw2.domain.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private WeatherService weatherService;

    public CityInfo getCityInfo(String cityName) {



    }


}
