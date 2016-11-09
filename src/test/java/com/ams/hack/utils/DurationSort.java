package com.ams.hack.utils;

import com.ams.hack.service.ModelConverter;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DurationSort {

    @Test
    public void cafeShouldNeverServeCoffeeItDoesntHave() {
       //Given:
        List<String> durations = Arrays.asList("PT1H1M", "PT46M", "PT1H28M", "PT3H19M", "PT9M", "PT19M", "PT3H1M", "PT25M");
        ModelConverter modelConverter = new ModelConverter();

        //When:
        List<String> sorted = durations.stream()
                .sorted((a,b) -> modelConverter.getStandardDuration(a).compareTo(modelConverter.getStandardDuration(b)))
                .collect(Collectors.toList());

       //Then:
        assertThat(sorted)
                .containsSequence("PT9M", "PT19M", "PT25M", "PT46M", "PT1H1M", "PT1H28M", "PT3H1M", "PT3H19M");
    }
}
