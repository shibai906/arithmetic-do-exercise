package com.zhao.multithreading.piped;

import com.zhao.multithreading.threadfactory.WorkThread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PipedThreadFactory implements ThreadFactory {
    private AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public Thread newThread(Runnable r) {

        System.out.println("使用ThreadFactory开始了");
        return new WorkThread(r,atomicInteger);

    }
}
