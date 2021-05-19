package cst438hw2.controller;

import cst438hw2.domain.CityInfo;
import cst438hw2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities/{city}")
    public String getCityInfo(@PathVariable("city") String cityName, Model model) {

        CityInfo city = cityService.getCityInfo(cityName);
        model.addAttribute("city", city);
        return "city";

    }

    @PostMapping("/cities/reservation")
    public String createReservation(
            @RequestParam("city") String cityName,
            @RequestParam("level") String level,
            @RequestParam("email") String email,
            Model model)
    {
        model.addAttribute("city", cityName);
        model.addAttribute("level", level);
        model.addAttribute("email", email);
        cityService.requestReservation(cityName, level, email);
        return "request_reservation";


    }
}
