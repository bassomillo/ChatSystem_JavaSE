package com;

//The Java volatile keyword is used to mark a Java variable as "being stored in main memory".
// More precisely that means, that every read of a volatile variable will be read from the
// computer's main memory, and not from the CPU cache, and that every write to a volatile
// variable will be written to main memory, and not just to the CPU cache.
public class ExistTest {
    private volatile static boolean flag = true;

    public static void main(String[] args) {
        new Thread(()->{
            while (flag){
            }
            System.out.println("t1");
        }).start();

        ThreadUtils.sleep(1000);
        flag=false;
    }
}
