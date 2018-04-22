package com.ktt.model;

import lombok.Data;

@Data
public class Root {
    private Station[] stations;

    public Root() {
    }

    public Root(Station[] stations) {
        this.stations = stations;
    }
}
