package com.test;

public class Test {
    public int count(String target, String tex){
        String[] strings = tex.split(" ");
        int res = 0;
        for (int i = 0; i < strings.length; i++) {
            if (target.equalsIgnoreCase(strings[i])){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "hello jdshf hello laf Hello";
        String tar = "helLo";
        Test test = new Test();
        System.out.println(test.count(tar,str));

    }



}
