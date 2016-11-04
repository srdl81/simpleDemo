package com.ams.hack.integration;

import com.ams.hack.dto.TripResultDTO;
import com.ams.hack.model.TripResult;
import com.ams.hack.repository.ResRobotRepository;
import com.ams.hack.service.ModelConverter;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.*;
import org.springframework.http.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private ResRobotRepository resRobotRepository;

    @Autowired
    private ModelConverter modelConverter;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void calculateDurationsWithIds() {
        //Given:
        String durationURI = "/duration/trip/ids?originId=740000789&destinationId=740000759";

        //When:
        ResponseEntity<TripResult> result = this.restTemplate.getForEntity(durationURI, TripResult.class);

        //Then:
        assertThat(result.getStatusCode() == HttpStatus.OK);
        assertThat(result.getBody().getTrips().size()).isEqualTo(6);
    }



    @Test
    public void calculateDurationsWithIdsThen200IsReceived() {

        //Given:
        String originId = "740000789";
        String destinationId = "740000759";

        //When:
        TripResultDTO resultDTO = resRobotRepository.receiveTravelTimeByIds(originId, destinationId);
        TripResult model = modelConverter.convertToModel(resultDTO);

        //Then:
        assertThat(model).isNotNull();
        assertThat(model.getTrips()).isNotNull();
        assertThat(model.getTrips().get(0).getDuration()).isNotNull();
    }
}
