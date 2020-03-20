package com.zhao.multithreading.completableFuture;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-20 00:29
 **/
public class CompletableFinish {

    private static ExecutorService service = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1000));

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger();
        Semaphore semaphore = new Semaphore(10);
        System.out.println(semaphore.availablePermits());
        while (integer.get() < 1000) {
            semaphore.acquire();
            CompletableFuture.runAsync(() -> {
                System.out.println(integer.incrementAndGet());
                semaphore.release();
            } , service);
        }
        System.out.println("执行了");

        while (semaphore.availablePermits() < 10) {
            Thread.sleep(10);
        }

        System.out.println(semaphore.availablePermits());
        System.out.println("over");
    }

}
