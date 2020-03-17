package com.zhao.multithreading.create.thread.callable;

import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-16 11:32
 **/
public class Client {

    private static ExecutorService executor = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = executor.submit(new MyCallable<>("你好"));
        System.out.println(future.get());
    }

}
