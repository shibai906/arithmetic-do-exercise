package com.zhao.multithreading.threadPool.basic;

import rx.internal.util.RxThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-06-26 15:59
 * @description
 **/
public class ThreadName {

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 100, TimeUnit.MINUTES, new ArrayBlockingQueue<>(400), new RxThreadFactory("测试线程池-"));
    static ThreadPoolExecutor executor1 = new ThreadPoolExecutor(2, 2, 100, TimeUnit.MINUTES, new ArrayBlockingQueue<>(400), new RxThreadFactory("我滴乖乖-"));
    static ThreadPoolExecutor executor2 = new ThreadPoolExecutor(2, 2, 100, TimeUnit.MINUTES, new ArrayBlockingQueue<>(400), new RxThreadFactory("我滴妈妈-"));
    static ThreadPoolExecutor executor3 = new ThreadPoolExecutor(2, 2, 100, TimeUnit.MINUTES, new ArrayBlockingQueue<>(400), new RxThreadFactory("我滴爸爸-"));
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {

//        ThreadPoolTaskExecutor
        for (int i = 0; i < 10; i ++) {
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100);
//                    System.out.println(System.currentTimeMillis());
                    fun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            executor1.execute(() ->{
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100);
//                    System.out.println(System.currentTimeMillis());
                    fun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            executor2.execute(() ->{
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100);
//                    System.out.println(System.currentTimeMillis());
                    fun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            executor3.execute(() ->{
                try {
                    Thread.sleep(100);
//                    System.out.println(System.currentTimeMillis());
                    fun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
//        executor.setTread

    }

    public static void fun() throws InterruptedException {

        for (int i = 0; i < 10; i ++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println(System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + ": " + "锁住" + atomicInteger.get());
                atomicInteger.incrementAndGet();
            });
        }
    }

}
