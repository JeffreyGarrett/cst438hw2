package cst438hw2.domain;

import javax.persistence.*;

@Entity
@Table(name="Country")
public class Country {

    @Id
    @Column(columnDefinition = "char")
    private String code;
    @Column(columnDefinition = "char")
    private String name;

    public Country() {}

    public Country(String code, String name){
        this.code=code;
        this.name=name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
