package cst438hw2.service;

import com.fasterxml.jackson.databind.JsonNode;
import cst438hw2.domain.TempAndTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class WeatherService {

    private static final Logger log =
            LoggerFactory.getLogger(WeatherService.class);
    private RestTemplate restTemplate;
    private String weatherUrl;
    private String apiKey;

    public WeatherService(
            @Value("${weather.url}") final String weatherUrl,
            @Value("${weather.apikey}") final String apiKey ) {
        this.restTemplate = new RestTemplate();
        this.weatherUrl = weatherUrl;
        this.apiKey = apiKey;

    }

    public TempAndTime getTimeAndTemp(String cityName) {
        ResponseEntity<JsonNode> response =
                restTemplate.getForEntity(
                        weatherUrl + "?q=" + cityName + "&appid=" + apiKey,
                        JsonNode.class);
        JsonNode json = response.getBody();
        log.info("Status code from weather server:" +
                response.getStatusCodeValue());
        double temp = Math.round((json.get("main").get("temp").asDouble() - 273.15) * 9.0 / 5.0 + 32.0);
        long time = json.get("dt").asLong();
        int timezone = json.get("timezone").asInt();
        String convertedTime = convertTime(time, timezone);
        return new TempAndTime(temp,convertedTime,timezone);
    }

    public String convertTime(long time, int timezone) {
        time = time * 1000; //new line
        Date date = new Date(time);
        DateFormat sdf = new SimpleDateFormat("h:mm a");
        TimeZone tz = TimeZone.getTimeZone("UTC");
        tz.setRawOffset(timezone * 1000);
        sdf.setTimeZone(tz);
        return sdf.format(date);
    }
}
