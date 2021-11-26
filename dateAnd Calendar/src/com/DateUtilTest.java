package com;

import java.text.ParseException;
import java.util.Date;

public class DateUtilTest {
    public static void main(String[] args) throws ParseException {
        Date now = DateUtil.now();
        Date now1 = DateUtil.now("1998-04-15 11:1:1");
        String date = DateUtil.nowString("yyyy/MM/dd HH:mm:ss");
        System.out.println(now);
        System.out.println(now1);
        System.out.println(date);
    }
}
