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

        assertThat(location.getId()).isNotNull();
        assertThat(location.getName()).isNotEmpty();
        assertThat(location.getCoordinates().getLatitude()).isPositive();
        assertThat(location.getCoordinates().getLongitude()).isPositive();
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

        assertThat(location.getId()).isNotNull();
        assertThat(location.getName()).isNotEmpty();
        assertThat(location.getCoordinates().getLatitude()).isPositive();
        assertThat(location.getCoordinates().getLongitude()).isPositive();
    }
}
