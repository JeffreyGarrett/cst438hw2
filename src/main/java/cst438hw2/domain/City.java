package cst438hw2.domain;

import cst438hw2.service.WeatherService;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City {

    @Id
    private int ID;
    @Column(columnDefinition = "char")
    private String name;
    @Column(columnDefinition = "char")
    private String district;
    private int population;
    @Column(columnDefinition = "char", insertable = false, updatable = false)
    private String countrycode;

    @Transient
    WeatherService weather;

    @ManyToOne
    @JoinColumn(name = "countrycode", referencedColumnName = "code")
    private Country country;

    public City(){
    }

    public City(int ID, String name, String district, int population, String country) {
        this.ID = ID;
        this.name = name;
        this.district = district;
        this.population = population;
        this.countrycode = country;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return this.countrycode;
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

    public WeatherService getWeather() {
        return weather;
    }

    public void setWeather(WeatherService weather) {
        this.weather = weather;
    }

}
