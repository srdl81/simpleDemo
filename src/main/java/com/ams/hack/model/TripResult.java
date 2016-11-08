package com.ams.hack.model;


public class TripResult {

    private Trip trip;

    public TripResult(Trip trip) {
        this.trip = trip;
    }

    public TripResult() {}

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
