package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date now(){
        return new Date();
    }

    public static Date now(String date, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.parse(date);
    }

    public static Date now(String date) throws ParseException {
        return now(date,DateUtil.DEFAULT_FORMAT);
    }

    public static String nowString(){
        return nowString(DateUtil.DEFAULT_FORMAT);
    }

    public static String nowString(String format){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.format(date);
    }
}
