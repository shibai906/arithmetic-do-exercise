package com.zhao.multithreading.threadPoolExce;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-06 01:04
 **/
public class Client {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    public static void main(String[] args) {
        System.out.println(1 << 1);
        System.out.println("RUNNING = " +RUNNING);
        System.out.println("CAPACITY = " +CAPACITY);
        System.out.println("SHUTDOWN = " +SHUTDOWN);
        System.out.println("STOP = " +STOP);
        System.out.println("TIDYING = " +TIDYING);
        System.out.println("TERMINATED = " +TERMINATED);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,1000, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10));
        executor.execute(() -> {
            System.out.println("哈哈哈");
        });
        executor.submit(() -> {
            System.out.println("呼哈哈哈");
        });
    }

}
