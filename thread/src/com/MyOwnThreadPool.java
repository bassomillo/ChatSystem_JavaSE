package com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyOwnThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(50),new MyThreadFactory("DeveloperGroup1-log"),
                (t,executor)->{
                    System.out.println("Cannot deal with this task");
                });
        for (int i = 0; i < 200; i++) {
            ThreadUtils.sleep(5000);
            executorService.submit(()->{
                ThreadUtils.sleep(5000);
                System.out.println("---------");
            });
        }


        executorService.shutdown();
    }



}
