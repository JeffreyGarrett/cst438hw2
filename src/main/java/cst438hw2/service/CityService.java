package cst438hw2.service;

import cst438hw2.domain.City;
import cst438hw2.domain.CityInfo;
import cst438hw2.domain.CityRepository;
import cst438hw2.domain.CountryRepository;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private WeatherService weatherService;
    private CityInfo cityInfo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanout;


    public CityInfo getCityInfo(String cityName) {
        List<City> cities = cityRepository.findByName(cityName);
        if(cities.size()==0) {
            return null;
        } else  {
            //If many take first
            City city = cities.get(0);

            return new CityInfo(city.getId(), city.getName(), city.getCountry().getName(),
                    city.getCountry().getCode(), city.getDistrict(), city.getPopulation(),
                    weatherService.getTimeAndTemp(cityName));
        }
    }

    public CityService(){}


    public CityService(CityRepository cityRepo, CountryRepository countryRepo, WeatherService weatherService){

        this.cityRepository = cityRepo;
        this.countryRepository = countryRepo;
        this.weatherService = weatherService;

    }

    public CityService(RabbitTemplate rabbitTemplate, FanoutExchange fanout) {
        this.rabbitTemplate = rabbitTemplate;
        this.fanout = fanout;
    }

    public void requestReservation(String cityName, String level, String email) {
        String msg = "{\"cityName\": \""+ cityName +
                "\" \"level\": \""+level+
                "\" \"email\": \""+email+"\"}" ;
        System.out.println("Sending message:"+msg);
        rabbitTemplate.convertSendAndReceive(

                fanout.getName(),
                "", // routing key none.

        msg);
    }
}
