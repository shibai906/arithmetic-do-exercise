package com.zhao.multithreading.futureTask;

import java.util.concurrent.Callable;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-16 15:55
 **/
public class MyCallableTest<T> implements Callable<T> {

    private T t;
    public MyCallableTest(T t) {
        this.t = t;
    }

    @Override
    public T call() throws Exception {
        System.out.println("我这里是用来联系用的");
        return t;
    }
}
