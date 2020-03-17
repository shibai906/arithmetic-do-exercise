package com.zhao.multithreading.create.thread.callable;

import java.util.concurrent.Callable;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-16 11:30
 **/
public class MyCallable<T> implements Callable<T> {
    private T t ;
    public MyCallable(T t) {
        this.t = t;
    }
    @Override
    public T call() throws Exception {
        System.out.println("你好哇，哈哈哈哈");
        return t;
    }
}
