package com.ams.hack.utils;


import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;

import static com.ams.hack.utils.GeneralDateUtils.*;

public class URIBuilderUtils {

    private static final String HTTPS = "https";
    private static final String RESROBOT = "api.resrobot.se";
    private static final String V2_TRIP = "/v2/trip";
    private static final String VALUE = "ff90d649-2b80-4bed-919d-cc672472a742";
    private static final String KEY = "key";
    private static final String ORIGIN_ID = "originId";
    private static final String DEST_ID = "destId";
    private static final String PASSLIST = "passlist";
    private static final String DATE = "date";
    private static final String TIME = "time";
    private static final String FORMAT = "format";
    private static final String ZERO = "0";
    private static final String TIME_VALUE = "07:30";
    private static final String JSON = "json";
    private static final String LOCATION = "/v2/location.name.json";
    private static final String INPUT = "input";
    private static final String LOCATION_NEARBYSTOPS = "/v2/location.nearbystops.json";
    private static final String ORIGIN_COORD_LAT = "originCoordLat";
    private static final String ORIGIN_COORD_LONG = "originCoordLong";
    private static final String DEST_COORD_LONG = "destCoordLong";
    private static final String DEST_COORD_LAT = "destCoordLat";

    public static String buildURLForIds(String originId, String destinationId) {

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme(HTTPS)
                        .host(RESROBOT)
                        .path(V2_TRIP)
                        .queryParam(KEY, VALUE)
                        .queryParam(ORIGIN_ID, originId)
                        .queryParam(DEST_ID, destinationId)
                        .queryParam(PASSLIST, ZERO)
                        .queryParam(DATE, calculateNextBusinessDate(LocalDate.now()))
                        .queryParam(TIME, TIME_VALUE)
                        .queryParam(FORMAT, JSON)
                        .build()
                        .encode();

        return uriComponents.toUriString();
    }

    public static String buildURLForCoordinates(String originCoordLong, String originCoordLat, String destCoordLong, String destCoordLat) {

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme(HTTPS)
                        .host(RESROBOT)
                        .path(V2_TRIP)
                        .queryParam(KEY, VALUE)
                        .queryParam(ORIGIN_COORD_LONG, originCoordLong)
                        .queryParam(ORIGIN_COORD_LAT, originCoordLat)
                        .queryParam(DEST_COORD_LONG, destCoordLong)
                        .queryParam(DEST_COORD_LAT, destCoordLat)
                        .queryParam(PASSLIST, ZERO)
                        .queryParam(DATE, calculateNextBusinessDate(LocalDate.now()))
                        .queryParam(TIME, TIME_VALUE)
                        .queryParam(FORMAT, JSON)
                        .build()
                        .encode();

        return uriComponents.toUriString();
    }


    public static String buildURLForLocation(String q) {
        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme(HTTPS)
                        .host(RESROBOT)
                        .path(LOCATION)
                        .queryParam(KEY, VALUE)
                        .queryParam(INPUT, q)
                        .build()
                        .encode();

        return uriComponents.toUriString();
    }

    public static String buildURLForLocationWithCoordinates(String originCoordLat, String originCoordLong) {
        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme(HTTPS)
                        .host(RESROBOT)
                        .path(LOCATION_NEARBYSTOPS)
                        .queryParam(KEY, VALUE)
                        .queryParam(ORIGIN_COORD_LAT, originCoordLat)
                        .queryParam(ORIGIN_COORD_LONG, originCoordLong)
                        .build()
                        .encode();

        return uriComponents.toUriString();
    }
}
