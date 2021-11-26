package com.templeteCodingMethod;

public class PoliticalPrisoner extends Prisoners{
    public PoliticalPrisoner(String name) {
        this.name = name;
    }

    @Override
    void work() {
        System.out.println(this.name+" Political prisoner is working");
    }

    @Override
    void eat() {
        System.out.println(this.name+" Political prisoner is eating");

    }

    @Override
    void readNews() {
        System.out.println(this.name+" Political prisoner is reading news");

    }
}
