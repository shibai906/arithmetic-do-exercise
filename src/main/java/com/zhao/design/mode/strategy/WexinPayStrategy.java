package com.zhao.design.mode.strategy;

public class WexinPayStrategy implements IPayStrategy {

    private final static IPayStrategy payStrategy = new WexinPayStrategy();
    private WexinPayStrategy() {
        if(payStrategy != null) {
            throw new RuntimeException("此对象是单例模式，不允许再被创建");
        }
    }
    public static IPayStrategy getInstance() {
        return payStrategy;
    }

    @Override
    public void pay() {
        System.out.println("微信支付.");
    }
}
