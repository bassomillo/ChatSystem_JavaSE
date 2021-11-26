package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Usercallable2 implements Callable<Long> {
    private int from;
    private int to;

    public Usercallable2() {
    }

    public Usercallable2(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        Long result = 0L;
        for (int i = from; i < to; i++) {

            result+=i;
        }
        return result;
    }

    //It can show that multiple threads can speed up the calculation
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        Long res = 0L;
        for (int i = 0; i < 100000000; i++) {
            res+=i;
        }
        Long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end-start);

        start = System.currentTimeMillis();
        res = 0L;
        FutureTask[] tasks= new FutureTask[10];
        for (int i = 0; i < 10; i++) {
            FutureTask<Long> task = new FutureTask<>(new Usercallable2(i*10000000,(i+1)*10000000));
            new Thread(task).start();
            tasks[i] = task;
        }
        for (int i = 0; i < 10; i++) {
            Long o = (Long)tasks[i].get();
            res+=o;
        }
        end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end-start);
    }
}
