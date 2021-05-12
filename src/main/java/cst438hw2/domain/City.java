package cst438hw2.domain;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City {

    @Id
    private int Id;
    private String name;
    private String district;
    private int population;

    @Transient
    TempAndTime TimeAndTempCity;

    @ManyToOne
    @JoinColumn(name="countrycode",referencedColumnName="code")
    private Country country;

    public City() {

    }

    public City(int id, String name, String district, int population, Country country) {
        this.Id = id;
        this.name = name;
        this.district = district;
        this.population = population;
        this.country = country;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public TempAndTime getTimeAndTempCity() {
        return TimeAndTempCity;
    }

    public void setTimeAndTempCity(TempAndTime timeAndTempCity) {
        TimeAndTempCity = timeAndTempCity;
    }

}
