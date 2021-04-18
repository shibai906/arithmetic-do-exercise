package com.zhao.multithreading.semaphore.demo;

import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-18 17:00
 **/
public class SimpleClient {

    private static ExecutorService executor = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));

    static class SameTest implements Runnable {

        Semaphore phore ;

        public SameTest(Semaphore phore) {
            this.phore = phore;
        }

        @Override
        public void run() {
            try {
                phore.acquire();
                Thread.sleep(1000);
                System.out.println("phore.acquire开始执行了，线程名称=" + Thread.currentThread().getName() + "-----------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("phore.release开始释放了，线程名称=" + Thread.currentThread().getName() + "!!!!!!!!!!!!!!!!!!");
            phore.release();

        }
    }

    public static void main(String[] args) {
        SimpleClient.SameTest sameTest = new SimpleClient.SameTest(new Semaphore(2,false));
        for(int i = 0 ; i < 10 ; i ++) {
            new Thread(sameTest).start();
        }
    }

}
