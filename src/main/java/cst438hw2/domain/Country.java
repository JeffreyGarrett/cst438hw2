package cst438hw2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

    private String name;
    @Id
    private String code;

    public Country () {

    }

    public Country (String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
