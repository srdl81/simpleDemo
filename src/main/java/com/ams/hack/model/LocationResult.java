package com.ams.hack.model;


import java.util.ArrayList;
import java.util.List;

public class LocationResult {

    public LocationResult(List<Location> locations) {
        this.locations = locations;
    }

    public LocationResult() {
    }

    private List<Location> locations = new ArrayList<>();

    public List<Location> getLocations() {
        return locations;
    }
}
