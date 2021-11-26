package com;

public class SynchronizedTest2 {
    private static final Object MONITOR = new Object();


    //can not synchronized in this case cuz each new class is different and has its own lock
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
//                say2();
                synchronized (SynchronizedTest2.MONITOR){
                    System.out.println(Math.random());
                    System.out.println("-------------------");
                }

            }).start();


        }
    }
}
