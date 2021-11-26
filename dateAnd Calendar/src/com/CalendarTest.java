package com;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("EDT"));
        //month is counted from zero
        Integer month = calendar.get(Calendar.MONTH);
        System.out.println(month);
        calendar.set(1998,Calendar.APRIL,15);
        calendar.set(Calendar.YEAR,1996);
        System.out.println(calendar.getTime());
    }
}
