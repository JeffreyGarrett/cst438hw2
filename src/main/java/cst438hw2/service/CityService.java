package cst438hw2.service;

import cst438hw2.domain.*;
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

    private CityInfo cityInfo;

    public CityInfo getCityInfo(String cityName) {
        //ystem.out.println("City Name: " + cityName );
        City city = cityRepository.findByName(cityName);
        Country country = countryRepository.findByCode(city.getCountryCode());
        TempAndTime tempAndTime = weatherService.getTempAndTime(cityName);

        this.cityInfo = new CityInfo(city.getID(), city.getName(), city.getCountryCode(),
                country.getName(), city.getDistrict(),
                city.getPopulation(), tempAndTime );

        return this.cityInfo;

    }

    public CityService(){}


    public CityService(CityRepository cityRepo, CountryRepository countryRepo, WeatherService weatherService){

        this.cityRepository = cityRepo;
        this.countryRepository = countryRepo;
        this.weatherService = weatherService;

    }


}
