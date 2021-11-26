package com;

public class SynchronizedTest {
    public static  void say(){
        ThreadUtils.sleep(100);
        System.out.println("say");
    }

    public synchronized  void say1(){
        ThreadUtils.sleep(100);
        System.out.println("say1");
    }

    public static synchronized void say2(){
        ThreadUtils.sleep(100);
        System.out.println("say2");
    }


    //can not synchronized in this case cuz each new class is different and has its own lock
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
//                say2();
                SynchronizedTest synchronizedTest = new SynchronizedTest();
                synchronizedTest.say1();
                System.out.println("-------------------");
            }).start();


        }
    }
}
