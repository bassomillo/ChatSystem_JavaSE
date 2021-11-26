package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleFormatTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        Date parse = simpleDateFormat.parse("21-10-16 10:23:24");
        System.out.println(parse);

    }
}
