package com.zhao.current.limiting;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.locks.ReentrantLock;

public class TestToken {
    static int z = 0;
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1);

        for(int i = 0 ; i < 100 ; i ++) {
            new Thread(() -> {
                System.out.println(rateLimiter.acquire()) ;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行第i个方法 + " + z ++);
                rateLimiter.getRate();
            }).start();
        }

    }

}
