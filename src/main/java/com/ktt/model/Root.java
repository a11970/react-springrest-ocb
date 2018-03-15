package com.ktt.model;

import lombok.Data;

@Data
public class Root {
    private Station[] stations;
    public Station[] getStations() {
        return stations;
    }
}
