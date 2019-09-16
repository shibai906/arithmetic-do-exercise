package com.zhao.design.mode.chain;

/**
 * 抽象处理器
 */
public abstract class Handler {

    // 领导名称
    protected String name ;

    public Handler(String name) {
        this.name = name;
    }

    // 下一个处理器
    protected Handler nextHandler;

    // 处理方法
    public abstract void handleRequest(LeaveRequest request);

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
