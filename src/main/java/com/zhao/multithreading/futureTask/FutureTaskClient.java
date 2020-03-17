package com.zhao.multithreading.futureTask;

import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-16 16:10
 **/
public class FutureTaskClient {

    private static ExecutorService service = new ThreadPoolExecutor(10,20,20, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<>(new MyCallableTest<>("test"));

        service.submit(futureTask);

        System.out.println(futureTask.get());
    }

}
