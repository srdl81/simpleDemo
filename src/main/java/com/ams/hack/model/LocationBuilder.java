package com.ams.hack.model;


public final class LocationBuilder {

    private String id;
    private String name;
    private Coordinates coordinates;

    private LocationBuilder() {
    }

    public static LocationBuilder aLocation() {
        return new LocationBuilder();
    }

    public LocationBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public LocationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public LocationBuilder withCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public Location build() {
        Location location = new Location();
        location.setId(id);
        location.setName(name);
        location.setCoordinates(coordinates);
        return location;
    }
}
