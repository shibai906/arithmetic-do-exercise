package com.zhao;

import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestJava {

    static long tatal = 0 ;
    static ReentrantReadWriteLock readWriteLock =new ReentrantReadWriteLock();
    static Lock redLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    static volatile boolean flag = true;
    static volatile char print = 'a';
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < 1000000000 ; i ++) {
            list.add(i);
        }
        long startTime = System.currentTimeMillis();

        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
          list.parallelStream().forEach( integer ->  tatal = integer + tatal);
          return tatal;
        }).exceptionally( e -> {
            e.printStackTrace();
            return 0L;});
        long endStartTime = System.currentTimeMillis();
        future.get(60, TimeUnit.MILLISECONDS);
        System.out.println(future.get() + "----" + tatal + ", 时间：" + (endStartTime - startTime));
/*        tatal = 0 ;
        long startTime = System.currentTimeMillis();
        list.stream().forEach(integer -> tatal = integer + tatal);
        long endStartTime = System.currentTimeMillis();
        System.out.println(tatal + ", 时间：" + (endStartTime - startTime));*/
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
