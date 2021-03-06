package com.zhao.design.mode.proxy.javaApi.aopProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

    private Object target ;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始了");
        Object obj = method.invoke(target,args);
        System.out.println("结束了");
        return obj;
    }
}
