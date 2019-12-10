package com.zhao.multithreading.threadPool.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2019-12-09 22:34
 **/
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(10,100,1, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(10));
        for(int i = 0 ; i < 20 ; i ++) {
            service.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
