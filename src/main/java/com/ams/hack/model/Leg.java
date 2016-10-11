package com.ams.hack.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Leg {

    @JsonProperty("Origin")
    private Origin origin;

    @JsonProperty("Destination")
    private Destination destination;

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
