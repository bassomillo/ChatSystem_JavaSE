package com;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLaunchTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable r1 = ()->{
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("r1");
            countDownLatch.countDown();
        };

        Runnable r2 = ()->{
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("r2");
            countDownLatch.countDown();
        };

        Runnable r3 = ()->{
            ThreadUtils.sleep(new Random().nextInt(5000));
            System.out.println("r3");
            countDownLatch.countDown();
        };

        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);
        countDownLatch.await();
        System.out.println("r1,r2,r3");
    }
}
