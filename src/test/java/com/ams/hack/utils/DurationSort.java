package com.ams.hack.utils;


import com.ams.hack.service.ModelConverter;
import org.joda.time.Duration;
import org.joda.time.format.ISOPeriodFormat;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DurationSort {

    @Test
    public void cafeShouldNeverServeCoffeeItDoesntHave() {
       //Given:
        List<String> durations = Arrays.asList("PT1H1M", "PT46M", "PT1H28M", "PT3H19M", "PT9M", "PT19M", "PT3H1M", "PT25M");

        //When:
        List<String> collect = durations.stream()
                .sorted((a,b) -> getStandardDuration(a).compareTo(getStandardDuration(b)))
                .collect(Collectors.toList());

//        collect.stream()
//                .forEach(o -> System.out.println(ModelConverter.prettyPrint(o)));



       //Then:
        Assert.assertFalse(false);
    }

    private Duration getStandardDuration(String a) {
        return ISOPeriodFormat.standard().parsePeriod(a).toStandardDuration();
    }
}
