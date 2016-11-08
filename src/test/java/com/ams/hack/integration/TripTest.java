package com.ams.hack.integration;

import com.ams.hack.model.Trip;
import com.ams.hack.model.TripResult;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TripTest {

    private static final Double ALVSJO_LATITUDE = new Double(59.278736);
    private static final Double ALVSJO_LONGITUDE = new Double(18.011066);
    private static final Double SOLNA_LATITUDE = new Double(59.365104);
    private static final Double SOLNA_LONGITUDE = new Double(18.010041);
    private static final String ALVSJO_ID = "740000789";
    private static final String ÄLVSJÖ_STATION = "Älvsjö station (Stockholm kn)";
    private static final String SOLNA_ID = "740000759";
    private static final String SOLNA_STATION = "Solna station";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void heckTripServiceByIds() {
        //Given:
        String durationURI = "/duration/trip/ids?originId=740000789&destinationId=740000759";

        //When:
        ResponseEntity<TripResult> result = restTemplate.getForEntity(durationURI, TripResult.class);
        Trip trip = result.getBody().getTrip();

        //Then:
        assertThat(result.getStatusCode() == HttpStatus.OK);
        assertThat(trip.getDuration()).isNotNull();

        assertThat(trip.getOrigin().getId()).isEqualTo(ALVSJO_ID);
        assertThat(trip.getOrigin().getName()).isEqualTo(ÄLVSJÖ_STATION);
        assertThat(trip.getOrigin().getCoordinates().getLatitude()).isEqualTo(ALVSJO_LATITUDE);
        assertThat(trip.getOrigin().getCoordinates().getLongitude()).isEqualTo(ALVSJO_LONGITUDE);

        assertThat(trip.getDestination().getId()).isEqualTo(SOLNA_ID);
        assertThat(trip.getDestination().getName()).isEqualTo(SOLNA_STATION);
        assertThat(trip.getDestination().getCoordinates().getLatitude()).isEqualTo(SOLNA_LATITUDE);
        assertThat(trip.getDestination().getCoordinates().getLongitude()).isEqualTo(SOLNA_LONGITUDE);
    }

    @Test
    public void checkTripServiceByCoordinates() {
        //Given:
        StringBuilder uri = new StringBuilder("/duration/trip/coordinates?")
                .append("originCoordLat=" + ALVSJO_LATITUDE)
                .append("&originCoordLong=" + ALVSJO_LONGITUDE)
                .append("&destCoordLat=" + SOLNA_LATITUDE)
                .append("&destCoordLong=" + SOLNA_LONGITUDE);

        //When:
        ResponseEntity<TripResult> result = restTemplate.getForEntity(uri.toString(), TripResult.class);
        Trip trip = result.getBody().getTrip();

        //Then
        assertThat(result.getStatusCode() == HttpStatus.OK);
        assertThat(trip.getDuration()).isNotNull();

        assertThat(trip.getOrigin().getName()).isNotNull();
        assertThat(trip.getOrigin().getCoordinates().getLatitude()).isPositive();
        assertThat(trip.getOrigin().getCoordinates().getLongitude()).isPositive();

        assertThat(trip.getDestination().getName()).isNotNull();
        assertThat(trip.getDestination().getCoordinates().getLatitude()).isPositive();
        assertThat(trip.getDestination().getCoordinates().getLongitude()).isPositive();
    }
}
