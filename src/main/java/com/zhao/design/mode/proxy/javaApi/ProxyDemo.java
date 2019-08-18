package com.zhao.design.mode.proxy.javaApi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {

    public static void main(String[] args) {
        InvocationHandler invocationHandler = new MyInocationHandler(new Car());
        ICar proxy = (ICar) Proxy.newProxyInstance(Car.class.getClassLoader(),Car.class.getInterfaces() ,invocationHandler);
        proxy.run();

    }

}
