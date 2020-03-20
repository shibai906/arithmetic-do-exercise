package com.zhao.multithreading.cyclicBarrier.demo;

import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-18 17:38
 * 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点。利用栅栏，可以使线程相互等待，直到所有线程都到达某一点，然后栅栏将打开，所有线程将通过栅栏继续执行
 **/
public class SimpleClient {

    private static ExecutorService executor = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(2);
        for(int i = 0 ; i < 5 ; i ++) {
            executor.execute(() ->{
                try {
                    System.out.println("await之前----------------------");
                    barrier.await();
                    System.out.println("await之后");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
