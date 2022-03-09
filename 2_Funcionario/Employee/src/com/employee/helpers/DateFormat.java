package com.employee.helpers;

import java.time.LocalDate;
import java.time.Month;

public class DateFormat {
    private int day;
    private int month;
    private int year;
    
    public DateFormat() {
    }
    
    public DateFormat(String[] date) {
        this.day = Integer.parseInt(date[0]);
        this.month = Integer.parseInt(date[1]);
        this.year = Integer.parseInt(date[2]);
    }
    
    public LocalDate getLocalDate() {
        switch (this.month) {
            case 1:
                return LocalDate.of(this.year, Month.JANUARY, this.day);
            case 2:
                return LocalDate.of(this.year, Month.FEBRUARY, this.day);
            case 3:
                return LocalDate.of(this.year, Month.MARCH, this.day);
            case 4:
                return LocalDate.of(this.year, Month.APRIL, this.day);
            case 5:
                return LocalDate.of(this.year, Month.MAY, this.day);
            case 6:
                return LocalDate.of(this.year, Month.JUNE, this.day);
            case 7:
                return LocalDate.of(this.year, Month.JULY, this.day); 
            case 8:
                return LocalDate.of(this.year, Month.AUGUST, this.day);
            case 9:
                return LocalDate.of(this.year, Month.SEPTEMBER, this.day);
            case 10:
                return LocalDate.of(this.year, Month.OCTOBER, this.day);
            case 11:
                return LocalDate.of(this.year, Month.NOVEMBER, this.day);
            case 12:
                return LocalDate.of(this.year, Month.DECEMBER, this.day);
            default:
                return null;
        }
    }
}