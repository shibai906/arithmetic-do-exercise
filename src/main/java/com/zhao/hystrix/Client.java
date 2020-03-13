package com.zhao.hystrix;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-09 16:13
 **/
public class Client {
    static AtomicInteger integer = new AtomicInteger(0);

    static ExecutorService executorService = new ThreadPoolExecutor(10, 15, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
    public static void main(String[] args) throws Exception {
        for( ; integer.get() < 100 ; ) {
            executorService.execute(() -> {
                MyHyStrix myHyStrix = new MyHyStrix("hystrix" , ()-> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "success";
                } , () -> {
                    return "fall";
                });
                try {

                    if(integer.incrementAndGet() == 20) {
                        System.out.println(myHyStrix.queue().get());
                    } else {
                        System.out.println(myHyStrix.queue().get());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.currentThread().join();

    }

}
