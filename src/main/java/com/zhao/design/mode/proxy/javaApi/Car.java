package com.zhao.design.mode.proxy.javaApi;

public class Car implements ICar {
    @Override
    public void run() {
        System.out.println("car run");
    }
}
