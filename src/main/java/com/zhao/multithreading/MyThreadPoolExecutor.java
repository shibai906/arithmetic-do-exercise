package com.zhao.multithreading;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class MyThreadPoolExecutor {

    public static void main(String[] args) {


        System.out.println( 3 << (Integer.SIZE - 3) - Integer.MAX_VALUE);

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.isLocked();
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("man");
        System.out.println(Integer.toBinaryString(1640531527));
//        LinkedBlockingQueue;
//        SynchronousQueue
    }

}
