package com.templeteCodingMethod;

public class StarPrisoner extends Prisoners{

    public StarPrisoner(String name){
        this.name = name;
    }
    @Override
    void work() {
        System.out.println(this.name+" singing and working");

    }

    @Override
    void eat() {
        System.out.println(this.name+" singing and eating");

    }

    @Override
    void readNews() {
        System.out.println(this.name+" singing and read news");

    }
}
