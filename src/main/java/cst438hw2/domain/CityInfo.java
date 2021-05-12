package cst438hw2.domain;

public class CityInfo {

    public int cityId;
    public String cityName;
    public String countryCode;
    public String countryName;
    public String cityDistrict;
    public int cityPopulation;
    public TempAndTime cityTempAndTime;
    public String temp;
    public String time;

    public CityInfo(int cityId, String cityName, String countryCode, String countryName, String cityDistrict, int cityPopulation, TempAndTime cityTempAndTime) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.cityDistrict = cityDistrict;
        this.cityPopulation = cityPopulation;
        this.cityTempAndTime = cityTempAndTime;

        this.temp = String.valueOf(cityTempAndTime.temp) + " Fahrenheit";
        this.time = String.valueOf(cityTempAndTime.time);

    }


}
