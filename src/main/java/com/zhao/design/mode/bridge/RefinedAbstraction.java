package com.zhao.design.mode.bridge;

public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        /*
         * 业务逻辑...
         */
        super.operation();
        // 调用其他方法
        this.implementor.doSomething();
    }

}
