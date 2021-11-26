package com;

public class UserThread extends Thread{
    @Override
    public void run() {
        System.out.println(2);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(1);
        new UserThread().start();
        Thread.sleep(10);
        System.out.println(3);
    }
}
