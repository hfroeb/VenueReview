package com.theironyard;

import org.junit.Assert;

import javax.validation.constraints.AssertTrue;

/**
 * Created by halleyfroeb on 11/16/16.
 */
public class HelperMethodTests {
    public static void main(String[] args) {

//Test JSON Military time convert to Standard time
        String time = "13:30:00";
        String[] columns = time.split(":");
        String standardTime1 = columns[0] + columns[1];

        int standardTime = (Integer.parseInt(standardTime1));
        if (standardTime > 1200) {
            standardTime = standardTime - 1200;
            String displayTime = Integer.toString(standardTime);
            if (displayTime.length() > 3) {
                displayTime = displayTime.substring(0, 2) + ":" + displayTime.substring(2, displayTime.length());
                displayTime = displayTime + " PM";
            } else {
                displayTime = displayTime.substring(0, 1) + ":" + displayTime.substring(1, displayTime.length());
                displayTime = displayTime + " PM";
            }
            System.out.println(displayTime);
        }
        else {
            String displayTime = Integer.toString(standardTime);
            if (displayTime.length() > 3) {
                displayTime = displayTime.substring(0, 2) + ":" + displayTime.substring(2, displayTime.length());
                displayTime = displayTime + " AM";
            } else {
                displayTime = displayTime.substring(0, 1) + ":" + displayTime.substring(1, displayTime.length());
                displayTime = displayTime + " AM";
            }
            System.out.println(displayTime);
            Assert.assertTrue(displayTime == "1:30 PM");
        }






    }

}
