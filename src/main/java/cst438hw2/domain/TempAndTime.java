package cst438hw2.domain;

public class TempAndTime {
    public double temp;
    public String time;
    public int timezone;

    public TempAndTime(double temp, String time, int timezone) {
        this.temp = temp;
        this.time = time;
        this.timezone = timezone;
    }
}