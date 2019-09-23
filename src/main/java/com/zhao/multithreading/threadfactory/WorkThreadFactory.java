package com.zhao.multithreading.threadfactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkThreadFactory implements ThreadFactory {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        int c = atomicInteger.incrementAndGet();
        System.out.println("create no " + c + " Threads ");
        return new WorkThread(r,atomicInteger);
    }
}
