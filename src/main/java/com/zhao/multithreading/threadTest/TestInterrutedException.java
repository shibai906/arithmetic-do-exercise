package com.zhao.multithreading.threadTest;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * 测试InterruptedException方法
 */
public class TestInterrutedException {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new ThreadA());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

        System.out.println(Thread.currentThread().getName());

//        AbstractQueuedLongSynchronizer

    }

}
