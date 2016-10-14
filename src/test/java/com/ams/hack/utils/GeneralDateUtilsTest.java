package com.ams.hack.utils;

import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeneralDateUtilsTest {

    @Test
    public void verifyThatNextBusinessDayIsAfterWeekendAndChristmas() {
        //Given:
        LocalDate localDate = LocalDate.of(2017,12, 22);

        //When:
        String nextBusinessDate = GeneralDateUtils.calculateNextBusinessDate(localDate);

        //Then:
        assertTrue(nextBusinessDate.equals("2017-12-27"));

    }

    @Test
    public void verifyThatNextBusinessDayIsAfterWeekend() {
       //Given:
        LocalDate localDate = LocalDate.of(2017,12, 8);

       //When:
        String nextBusinessDate = GeneralDateUtils.calculateNextBusinessDate(localDate);

        //Then:
        assertTrue(nextBusinessDate.equals("2017-12-11"));

    }

    @Test
    public void verifyThatItsNotBusinessDay() {
        //Given:
        LocalDate localDate = LocalDate.of(2017, 12, 16);

        //When:
        boolean hollyday = GeneralDateUtils.isBusinessDay(localDate);

        //Then:
        assertFalse(hollyday);
    }


    @Test
    public void verifyThatItsBusinessDay() {
        //Given:
        LocalDate localDate = LocalDate.of(2017, 12, 18);

        //When:
        boolean hollyday = GeneralDateUtils.isBusinessDay(localDate);

        //Then:
        assertTrue(hollyday);
    }

    @Test
    public void verifyThatItsNotAHollyday() {
        //Given:
        LocalDate localDate = LocalDate.of(2017, 10, 18);

        //When:
        boolean hollyday = GeneralDateUtils.isHollyday(localDate);

        //Then:
        assertFalse(hollyday);
    }

    @Test
    public void verifyThatNationalDayIsAHollyday() {
        //Given:
        LocalDate localDate = LocalDate.of(2017, 06, 06);

        //When:
        boolean hollyday = GeneralDateUtils.isHollyday(localDate);

        //Then:
        assertTrue(hollyday);
    }

    @Test
    public void verifyThatChristmasDayIsAHollyday() {
       //Given:
        LocalDate localDate = LocalDate.of(2016, 12, 25);

       //When:
        boolean hollyday = GeneralDateUtils.isHollyday(localDate);

        //Then:
        assertTrue(hollyday);
    }

    @Test
    public void verifyThatSaturdayIsNotAWorkingDay() {
        //given
        LocalDate localDate = LocalDate.of(2016, 10, 15);

        //when
        boolean workingDay = GeneralDateUtils.isWorkingDay(localDate);

        //then
        assertFalse(workingDay);
    }

    @Test
    public void verifyThatFridayIsAWorkingDay() {
        //given
        LocalDate localDate = LocalDate.of(2016, 10, 14);

        //when
        boolean workingDay = GeneralDateUtils.isWorkingDay(localDate);

        //then
        assertTrue(workingDay);
    }
}