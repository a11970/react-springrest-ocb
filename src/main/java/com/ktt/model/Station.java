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

    public Station() {
    }

    public Station(String id, String title, String subtitle, String in_service, String number_of_locks, Availability availability) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.in_service = in_service;
        this.number_of_locks = number_of_locks;
        this.availability = availability;
    }
}
