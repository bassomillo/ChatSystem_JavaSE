package com.singletonCodingMethod;

//the best way to code
public class Singleton3 {

    //initial
    private static Singleton3 INSTANCE ;

    //others cannot new the class
    private Singleton3(){

    }

    //Static inner class will be load only once when firstly used
    //And static constant will be initialized only once when inner class be load
    private static class SingletonHolder{
        private static final Singleton3 INSTANCE =new Singleton3();
    }

    //others can get the instance class
    public static Singleton3 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
