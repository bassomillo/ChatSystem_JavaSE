package com.singletonCodingMethod;

public class Client {
    public static void main(String[] args) {
        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance1 = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        Singleton3 instance3 = Singleton3.getInstance();

        System.out.println(instance == instance3);
    }
}
