package com.zhao.multithreading.threadfactory;

import java.util.concurrent.*;

public class TestThreadFactory {

    public static void main(String[] args) {
        simple();
    }

    public static void simple() {
        ThreadFactory customThreadfactory = new CustomThreadFactoryBuilder().setNamePrefix("DemoPool-Thread").setDaemon(false).setPriority(Thread.MAX_PRIORITY).build();
        ExecutorService executorService = Executors.newFixedThreadPool(3,customThreadfactory);

        // Create three simple tasks with 1000 ms sleep time
        SimpleTask simpleTask1 = new SimpleTask(1000);
        SimpleTask simpleTask2 = new SimpleTask(1000);
        SimpleTask simpleTask3 = new SimpleTask(1000);

        // Execute three simple tasks with 1000 ms sleep time
        executorService.execute(simpleTask1);
        executorService.execute(simpleTask2);
        executorService.execute(simpleTask3);

    }

    public static void worker() {
        ExecutorService es = Executors.newCachedThreadPool(new WorkThreadFactory());

        // 同时并发5个工作线程
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        // 指示当所有线程执行完毕后关闭线程池和工作线程，如果不调用此方法，jvm不会自动关闭
        es.shutdown();
        try {
            //等待线程执行完毕，不能超过2*60秒，配合shutDown
            es.awaitTermination(2*60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
