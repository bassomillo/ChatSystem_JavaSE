package com.singletonCodingMethod;

//maybe problematic during multiprocessor coding
public class Singleton2 {

    //initial
    private static  Singleton2 INSTANCE ;
    //others cannot use
    private Singleton2(){

    }

    //others can read
    public static Singleton2 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton2();
        }

        return INSTANCE;
    }
}
