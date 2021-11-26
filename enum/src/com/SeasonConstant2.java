package com;

public class SeasonConstant2 {

    private SeasonConstant2() {

    }

    private SeasonConstant2(int value, String name) {
    }

    public static final SeasonConstant2 SPRING = new SeasonConstant2(1,"Spring");
    public static final SeasonConstant2 SUMMER = new SeasonConstant2(2,"Summer");
    public static final SeasonConstant2 AUTUMN = new SeasonConstant2(3,"Autumn");
    public static final SeasonConstant2 WINTER = new SeasonConstant2(4,"Winter");

    public static void main(String[] args) {
        System.out.println(SeasonConstant2.AUTUMN==SeasonConstant2.AUTUMN);
    }
}
