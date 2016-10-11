package com.ams.hack.model;


import java.util.ArrayList;
import java.util.List;

public class TravelSummaries {
    private List<TravelSummary> trips = new ArrayList<>();

    public List<TravelSummary> getTrips() {
        return trips;
    }

    public void setTrips(List<TravelSummary> trips) {
        this.trips = trips;
    }
}
