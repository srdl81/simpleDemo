package com.ams.hack.utils;


import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class DateUtils {

    private static HolidayManager holydayManager =  HolidayManager.getInstance(HolidayCalendar.SWEDEN);

    public static boolean isBusinessDay(LocalDate localDate) {
        if (isWorkingDay(localDate) && !isHollyday(localDate)) {
            return true;
        }

        return false;
    }

    public static boolean isWorkingDay(LocalDate localDate) {
        DayOfWeek day = localDate.getDayOfWeek();
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY){
            return false;
        }

        return true;
    }

    public static boolean isHollyday(LocalDate localDate) {
        return holydayManager.isHoliday(localDate, "");
    }

    public static String calculateNextBusinessDate(LocalDate localDate) {
        LocalDate date = localDate.plusDays(1);
        while (!DateUtils.isBusinessDay(date)) {
            date = date.plusDays(1);
        }

        return date.toString();
    }

}
