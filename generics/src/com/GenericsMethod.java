package com;

public class GenericsMethod {

    public <T> T inner(T t){
        return t;
    }

    public static void main(String[] args) {
        System.out.println(new GenericsMethod().inner("a"));
    }
}
