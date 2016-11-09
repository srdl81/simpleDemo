package com.ams.hack.integration;

import com.ams.hack.model.Location;
import com.ams.hack.model.LocationResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationTest {

    private static final String ALVSJO_ID = "740000789";
    private static final String ALVSJÖ_STATION = "Älvsjö station (Stockholm kn)";
    private static final Double ALVSJO_LATITUDE = 59.278736;
    private static final Double ALVSJO_LONGITUDE = 18.011066;

    private static final String HANDEN_ID = "740098490";
    private static final String HANDEN = "HANDEN";
    private static final double HANDEN_LATITUDE = 59.167566;
    private static final double HANDEN_LONGITUDE = 18.13447;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void checkLocationByNameExpectStatusCode200() {
        //Given:
        String uri = "/location/handen";

        //When:
        ResponseEntity<LocationResult> result = restTemplate.getForEntity(uri, LocationResult.class);
        Location location = result.getBody().getLocations().stream().findFirst().get();

        //Then:
        assertThat(result.getStatusCode() == HttpStatus.OK);

        assertThat(location.getId()).isEqualTo(HANDEN_ID);
        assertThat(location.getName()).isEqualToIgnoringCase(HANDEN);
        assertThat(location.getCoordinates().getLatitude()).isEqualTo(HANDEN_LATITUDE);
        assertThat(location.getCoordinates().getLongitude()).isEqualTo(HANDEN_LONGITUDE);
    }

    @Test
    public void checkLocationByCoordinatesExpectStatusCode200() {
        //Given:
        String uri = "/location/nearbystops?latitude=59.278736&longitude=18.011066";

        //When:
        ResponseEntity<LocationResult> result = restTemplate.getForEntity(uri, LocationResult.class);
        Location location = result.getBody().getLocations().stream().findFirst().get();

        //Then:
        assertThat(result.getStatusCode() == HttpStatus.OK);

        assertThat(location.getId()).isEqualTo(ALVSJO_ID);
        assertThat(location.getName()).isEqualTo(ALVSJÖ_STATION);
        assertThat(location.getCoordinates().getLatitude()).isEqualTo(ALVSJO_LATITUDE);
        assertThat(location.getCoordinates().getLongitude()).isEqualTo(ALVSJO_LONGITUDE);
    }
}
