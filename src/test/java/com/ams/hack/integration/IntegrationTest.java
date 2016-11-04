package com.ams.hack.integration;

import com.ams.hack.model.TripResult;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void calculateDurationsWithIds() {
        //Given:
        String durationURI = "/duration/trip/ids?originId=740000789&destinationId=740000759";

        //When:
        TripResult result = this.restTemplate.getForObject(durationURI, TripResult.class);

        //Then:
        assertThat(result.getTrips().size()).isEqualTo(6);
    }

}
