package com;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Long time = new Date().getTime();
        time = time+7*24*3600000;
        Date date = new Date(time);
        System.out.println(date);
    }
}
