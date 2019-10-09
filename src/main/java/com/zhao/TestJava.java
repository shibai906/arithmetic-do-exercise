package com.zhao;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestJava {


    static ReentrantReadWriteLock readWriteLock =new ReentrantReadWriteLock();
    static Lock redLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    static volatile boolean flag = true;
    static volatile char print = 'a';
    public static void main(String[] args) {
        new Thread(() -> {
            while (print <= 'z') {
                if(flag) {
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    flag = false;
                }
            }
        }).start();
        new Thread(() -> {
            while (print <= 'z') {
                if(!flag) {
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    flag = true;
                }
            }
        }).start();
    }

    private static void testFlag() {
        new Thread(() -> {
            while (print <= 'z') {
                if(flag) {
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    flag = false;
                }
            }
        }).start();
        new Thread(() -> {
            while (print <= 'z') {
                if(!flag) {
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    flag = true;
                }
            }
        }).start();
    }

    private static void testReadWriteLock() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> {
            while (print <= 'z') {
                if((print - 'a') % 2 == 0 ) {
                    redLock.lock();
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    redLock.unlock();
                }
            }
        });
        service.submit(() -> {
            while (print <= 'z') {
                if((print - 'a') % 2 == 1 ) {
                    writeLock.lock();
                    System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                    writeLock.unlock();
                }
            }
        });
        service.shutdown();
    }

    private static void testSynchronized(String[] args) {
        new Thread(() ->{
            synchronized (args) { // 锁的名称
                while (print <= 'z') {
                    if((print - 'a') % 2 == 0 ) {
                        System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                        args.notify();
                    } else {
                        try {
                            args.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() ->{
            synchronized (args) { // 锁的名称
                while (print <= 'z') {
                    if((print - 'a') % 2 == 1 ) {
                        System.out.println(Thread.currentThread().getName() + "--------" + print ++);
                        args.notify();
                    } else {
                        try {
                            args.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

}
