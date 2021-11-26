package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = ()->{
            ThreadUtils.sleep(10000);
            System.out.println("-------------");
        };
        for (int i = 0; i < 100; i++) {
            executorService.submit(runnable);
        }
    }
}
