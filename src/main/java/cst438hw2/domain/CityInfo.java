package cst438hw2.domain;

public class CityInfo {
    private int id;
    private String cityName;
    private String countryName;
    private String countryCode;
    private String district;
    private int population;
    private TempAndTime timeAndTemp;

    public CityInfo(int id, String cityName,String countryName, String countryCode,
                    String district , int population, TempAndTime timeAndTemp) {
        this.id = id;
        this.cityName = cityName;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
        this.timeAndTemp = timeAndTemp;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public TempAndTime getTimeAndTemp() {
        return timeAndTemp;
    }
    public void setTimeAndTemp(TempAndTime timeAndTemp) {
        this.timeAndTemp = timeAndTemp;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}

