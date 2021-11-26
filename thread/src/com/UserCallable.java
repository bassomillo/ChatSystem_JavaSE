package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UserCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(100);
        return 200;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(1);
        //save a future return value
        FutureTask<Integer> futureTask = new FutureTask<>(new UserCallable());
        new Thread(futureTask).start();
        //stuck the main thread and wait for the return value
        Integer result = futureTask.get();
        System.out.println(result);
        System.out.println(2);
    }
}
