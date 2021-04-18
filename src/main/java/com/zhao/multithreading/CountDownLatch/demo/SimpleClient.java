package com.zhao.multithreading.CountDownLatch.demo;

import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-18 18:20
 * 同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。即，一组线程等待某一事件发生，事件没有发生前，
 * 所有线程将阻塞等待；而事件发生后，所有线程将开始执行；闭锁最初处于封闭状态，当事件发生后闭锁将被打开，一旦打开，闭锁将永远处于打开状态。
 * 可以这样理解为，countDown减完了之后，才运行await方法
 **/
public class SimpleClient {

    private static ExecutorService executor = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        executor.execute(() -> {
            System.out.println("闭锁开始----------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("闭锁结束");
            latch.countDown();
        });
        executor.execute(() -> {
            System.out.println("闭锁开始----------------");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("闭锁结束");
            latch.countDown();
        });
        executor.execute(() -> {
            System.out.println("闭锁开始----------------");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("闭锁结束");
            latch.countDown();
        });

        latch.await();
        System.out.println("当前面三个线程都执行完了，然后才开始执行主线程");

    }

}
