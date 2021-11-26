package com;

//We can see that yield is a command that the thread can release the cpu
public class YieldTest {
    private static int count1 = 0;
    private static int count2 = 0;

    public static void add1(){
        System.out.println("Thread1 "+count1++);
    }
    public static void add2(){
        System.out.println("Thread2 "+count2++);
    }

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                Thread.yield();
                add1();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                add2();
            }
        }).start();
    }
}
