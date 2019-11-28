package com.zhao.multithreading.threadfactory;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal();
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cy = new CyclicBarrier(2);

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> {
            threadLocal.set(238234987);
        });
        threadLocal.set(5201);
        System.gc();
        Thread.sleep(1000);
        System.out.println(threadLocal.get());
    }

}
