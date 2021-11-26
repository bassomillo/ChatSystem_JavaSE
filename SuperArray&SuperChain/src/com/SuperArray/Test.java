package com.SuperArray;

public class Test {
    public static void main(String[] args) {
        SuperArray superArray = new SuperArray(2);
        superArray.addToTail(12);
        superArray.addToTail(13);
        superArray.addToTail(14);
        superArray.add(1,3);
//        superArray.delete(10);
//        superArray.set(0,4);
//        superArray.select(20);
//        for (int i = 0; i < superArray.arrayLength(); i++) {
//            System.out.println(superArray.select(i));
//        }
        System.out.println(superArray.arrayToString());
    }
}
