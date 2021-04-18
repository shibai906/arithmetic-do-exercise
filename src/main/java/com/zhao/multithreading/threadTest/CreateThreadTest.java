package com.zhao.multithreading.threadTest;

import java.util.concurrent.*;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-01-24 20:40
 * @description
 **/
public class CreateThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));
        poolExecutor.execute(() -> {
            System.out.println("test thread pool executor runnable");
        });
        Future<String> future = poolExecutor.submit(() -> "test thrad poll executor callable");
        System.out.println(future.get());
    }
}
class ThreadCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 10;
    }
}

class ThreadRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("test thread runnable");
    }
}


class ThreadExtends extends Thread {

    @Override
    public void run() {
        System.out.println("你好");
    }
}
