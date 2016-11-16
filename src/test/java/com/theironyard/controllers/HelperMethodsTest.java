package com.theironyard.controllers;

import org.hibernate.annotations.SourceType;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by halleyfroeb on 11/16/16.
 */
public class HelperMethodsTest {
    @Test
    public void convertTimeTest() throws Exception {
        String[] testTimes = {"13:00:00", "12:00:00", "24:00:00", "24:30:00", "03:00:00"};
        String[] newTimes = new String[5];
        for (int i = 0; i < testTimes.length; i++){
            String time = testTimes[i];
            newTimes[i] = HelperMethods.convertTime(time);
        }
        String[] expectedTimes = {"1:00 PM", "12:00 PM", "12:00 AM", "12:30 PM", "3:00 AM"};
        assertArrayEquals(expectedTimes, newTimes);
}
    @Test
    public void convertDateTest() throws ParseException {
        String date = "2016-11-18";
        String newDate = HelperMethods.convertDate(date);
        assertTrue(newDate.equalsIgnoreCase("Friday, Nov 18, 2016"));
    }




}