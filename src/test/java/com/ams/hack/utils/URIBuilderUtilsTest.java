package com.ams.hack.utils;

import org.junit.Test;

import static org.junit.Assert.*;


public class URIBuilderUtilsTest {

    private final static String URL_WITH_LOCATION = "https://api.resrobot.se/v2/location.name.json?key=ff90d649-2b80-4bed-919d-cc672472a742&input=stockholm";
    private final static String URL_WITH_ID = "https://api.resrobot.se/v2/trip?key=ff90d649-2b80-4bed-919d-cc672472a742&originId=740000001&destId=740000003&passlist=0&date=2016-10-18&time=07:30&format=json";
    private final static String URL_WITH_COORDINATES = "https://api.resrobot.se/v2/trip?key=ff90d649-2b80-4bed-919d-cc672472a742&originCoordLat=59.330136&originCoordLong=18.058151&destCoordLat=56.898778&destCoordLong=14.556322&passlist=0&date=2016-10-18&time=07:30&format=json";
    private final static String URL_WITH_COORDINATE = "https://api.resrobot.se/v2/location.nearbystops.json?key=ff90d649-2b80-4bed-919d-cc672472a742&originCoordLat=59.330136&originCoordLong=18.058151";

    @Test
    public void testBuildURLForIds() throws Exception {
        //Given:
        String originId = "740000001";
        String destinationId = "740000003";

        //When:
        String url = URIBuilderUtils.buildURLForIds(originId, destinationId);

        //Then
        assertEquals("URL not as expected.", URL_WITH_ID, url);
    }

    @Test
    public void testBuildURLForCoordinates() throws Exception {
        //Given:
        String originLatitude = "59.330136";
        String originLongitude = "18.058151";

        String destinationLatitude = "56.898778";
        String destinationLongitude = "14.556322";

        //When:
        String url = URIBuilderUtils.buildURLForCoordinates(originLatitude, originLongitude, destinationLatitude, destinationLongitude);

        //Then
        assertEquals("URL not as expected.", URL_WITH_COORDINATES, url);
    }

    @Test
    public void testBuildURLForLocation() throws Exception {
        //Given:
        String location = "stockholm";

        //When:
        String url = URIBuilderUtils.buildURLForLocation(location);

        //Then:
        assertEquals("URL not as expected.", URL_WITH_LOCATION, url);
    }

    @Test
    public void testBuildURLForLocationWithCoordinates() throws Exception {
        //Given:
        String latitude = "59.330136";
        String longitude = "18.058151";

        //When:
        String url = URIBuilderUtils.buildURLForLocationWithCoordinates(latitude, longitude);

        //Then:
        assertEquals("URL not as expected.", URL_WITH_COORDINATE, url);

    }
}