package com.ktt.model;

import lombok.Data;

@Data
public class Availability {
    private String bikes;
    private String locks;

    public Availability() {
    }

    public Availability(String bikes, String locks) {
        this.bikes = bikes;
        this.locks = locks;
    }
}
