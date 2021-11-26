package com.singletonCodingMethod;

public class Singleton {

    //initial
    private static final Singleton INSTANCE =  new Singleton();
    //others cannot use
    private Singleton(){

    }

    //others can read
    public static Singleton getInstance(){
        return INSTANCE;
    }
}
