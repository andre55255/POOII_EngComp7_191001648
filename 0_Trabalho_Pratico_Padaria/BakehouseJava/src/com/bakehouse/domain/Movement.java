package com.bakehouse.domain;

import java.time.LocalDate;

public class Movement {
    private int id;
    private String description;
    private LocalDate dateHour;
    private double value;
    private char type;
    
    private User user;
}