package cst438hw2.controller;

import cst438hw2.domain.City;
import cst438hw2.domain.CityInfo;
import cst438hw2.domain.CityRepository;
import cst438hw2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/api/cities/{city}")
    public ResponseEntity<CityInfo> getWeather(@PathVariable("city") String cityName) {
        List<City> cities = cityRepository.findByName(cityName);
        if(cities.size()==0) {
            return new ResponseEntity<CityInfo>(HttpStatus.NOT_FOUND);
        } else {
            CityInfo city = cityService.getCityInfo(cities.get(0).getName());

            return new ResponseEntity<CityInfo>(city, HttpStatus.OK);
        }
    }
}
