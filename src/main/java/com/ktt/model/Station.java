package com.ktt.model;

import lombok.Data;

@Data
public class Station {
    private String id;
    private String title;
    private String subtitle;
    private String in_service;
    private String number_of_locks;
    private Availability availability;

    public String getId() {
        return id;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
