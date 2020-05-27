package com.zhao.multithreading.aqs;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-05-14 14:25
 **/
public class Client {



    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(4);
//
//
//        new Thread(() -> {
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("执行了");
//        }).start();
//
//        System.out.println("无奈");
//
//        new Thread(() -> {
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("执行了");
//        }).start();
//        Thread.sleep(1000 * 10000);
//        countDownLatch.countDown();
//        countDownLatch.countDown();
//        countDownLatch.countDown();
//        countDownLatch.countDown();
//        Thread.sleep(1000);


        ReentrantLock lock = new ReentrantLock(true);

        Condition con = lock.newCondition();

        new Thread(() -> {
//            lock.lock();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lock.unlock();
            lock.lock();
            try {
                con.await();
//                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();

//            try {
//                con.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("你好啊");
            con.signal();
            lock.unlock();
        }).start();

        Thread.currentThread().join();

//        for(int i = 0 ; i < 10 ; i ++) {
//            new Thread(() -> {
//                lock.lock();
//                try {
//                    Thread.sleep(60 * 1000 * 2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                lock.unlock();
//            }).start();
//        }
//        lock.lock();
//        lock.unlock();




        System.out.println(lock.getQueueLength());
    }

}
