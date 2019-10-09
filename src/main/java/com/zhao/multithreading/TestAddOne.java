package com.zhao.multithreading;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TestAddOne {
    static volatile int a = 0;
    static Set<Integer> set = new TreeSet<Integer>();
    public static void main(String[] args) throws InterruptedException {

        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        for(int i = 0 ; i < 10 ; i ++) {
            executor.submit(() ->{
                for(int j = 0 ; j < 10 ; j ++) {
                    System.out.println(a++);
                }
            });
        }*/

        for(int i = 0 ; i < 100 ; i ++) {
            new Thread(() ->{
                for(int j = 0 ; j < 10 ; j ++) {
                    synchronized (TestAddOne.class) {
                        set.add(a++);
                    }
                }
            }).start();
        }
        Thread.sleep(1000);

        set.size();


    }

}
