package com.zhao.design.mode.proxy.javaApi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInocationHandler implements InvocationHandler {

    private final  ICar car;

    public MyInocationHandler(ICar car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object result = method.invoke(car,args);
        System.out.println("after");
        return result;
    }
}
