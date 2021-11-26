package com;

//this is a test for 守护线程
public class Deamon {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            int count = 10;
            Thread t2 = new Thread(()->{
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("I am a deamon thread");
                }
            });
            t2.setDaemon(true);
            t2.start();
            while (count>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am a user thread");
                count--;
            }
            System.out.println("User Thread dead---------");
        });
//        t1.setDaemon(true);
        t1.start();
    }
}
