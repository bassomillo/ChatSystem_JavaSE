package com;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime edt = instant.atZone(ZoneId.of("GMT+08:00"));
        System.out.println(edt);

    }
}
