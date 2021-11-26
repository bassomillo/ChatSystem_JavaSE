package com;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {

    private static final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    MyThreadFactory(String prefix) {
        SecurityManager s = System.getSecurityManager();
        namePrefix = prefix+"--"+threadNumber.getAndIncrement()+"-thread";
    }

    public Thread newThread(Runnable r) {
        return new Thread(r,namePrefix);
    }
}
