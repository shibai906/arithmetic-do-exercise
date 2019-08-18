package com.zhao.design.mode.bridge;

public abstract class Abstraction {

    // 对实现化角色引用
    protected Implementor implementor;

    // 约束子类必须完成该构造函数
    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    // 自身行为
    public void operation() {
        this.implementor.doSomething();
    }

}
