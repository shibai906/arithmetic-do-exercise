package com.zhao.design.mode.bridge;

public class ConcreteImplementorA implements Implementor {
    @Override
    public void doSomething() {
        // 业务处理逻辑
        System.out.println("print doSomething");
    }
}
