package com.zhao.spring;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-04 16:05
 **/
public class TestBoss {

    final static ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>();

    ExecutorService ser = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1));

    volatile String translate;

    public static void main(String[] args) {


    }

}