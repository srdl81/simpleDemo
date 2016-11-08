package com.ams.hack.model;


public final class TripBuilder {
    private Origin origin;
    private Destination destination;
    private String duration;

    private TripBuilder() {
    }

    public static TripBuilder aTrip() {
        return new TripBuilder();
    }

    public TripBuilder withOrigin(Origin origin) {
        this.origin = origin;
        return this;
    }

    public TripBuilder withDestination(Destination destination) {
        this.destination = destination;
        return this;
    }

    public TripBuilder withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public TripResult build() {
        Trip trip = new Trip();
        trip.setOrigin(origin);
        trip.setDestination(destination);
        trip.setDuration(duration);

        return new TripResult(trip);
    }
}
