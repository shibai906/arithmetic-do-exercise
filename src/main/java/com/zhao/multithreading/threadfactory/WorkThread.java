package com.zhao.multithreading.threadfactory;

import java.util.concurrent.atomic.AtomicInteger;

public class WorkThread extends Thread {

    private Runnable target; // 线程执行目标
    private AtomicInteger counter;

    public WorkThread(Runnable target , AtomicInteger counter) {
        this.counter = counter;
        this.target = target;
    }

    @Override
    public void run() {
        try {
            target.run();
        } finally {
            int c = counter.getAndDecrement();
            System.out.println("terminate no " + c + " Threads");
        }
    }
}
