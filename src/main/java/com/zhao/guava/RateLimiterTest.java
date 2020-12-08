package com.zhao.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-23 12:26
 * @description
 **/
public class RateLimiterTest {

    private static RateLimiter rateLimiter = RateLimiter.create(1);


    public static void main(String[] args) throws InterruptedException {

        for(int i = 0 ; i < 100 ; i ++) {
            boolean tryAcquire = rateLimiter.tryAcquire(0, TimeUnit.SECONDS);
            if(i % 10 == 0) {
                Thread.sleep(10000);
            }
            if(tryAcquire) {
                System.out.println("我正常运行了");
            } else {
                System.out.println("我限流了");
            }
        }
    }

}
