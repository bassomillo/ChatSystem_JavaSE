package com;

public class UserRunnable implements Runnable {
    @Override
    public void run() {

        System.out.println(2);
    }

    public static void main(String[] args) {
        System.out.println(1);
        new Thread(new UserRunnable()).start();
        new Thread(()->{
            System.out.println("hello");
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello2");
            }
        }).start();
        System.out.println(3);
    }
}
