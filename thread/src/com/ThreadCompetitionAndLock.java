package com;

public class ThreadCompetitionAndLock implements Runnable{
    private static int count = 100;

    private String name;

    public ThreadCompetitionAndLock(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ThreadCompetitionAndLock.count>0){
            synchronized (ThreadCompetitionAndLock.class){
                ThreadUtils.sleep(100);
                System.out.println(this.name+"sold one ticket, left "+count--+" tickets");
            }
//            System.out.println(this.name+"sold one ticket, left "+count--+" tickets");
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadCompetitionAndLock("No.1"));
        Thread thread2 = new Thread(new ThreadCompetitionAndLock("No.2"));
        thread1.start();
        thread2.start();
    }
}
