package com.zhao.design.mode.strategy;

public class AliPayStrategy implements IPayStrategy {

    private final static AliPayStrategy aliPayStrategy = new AliPayStrategy();
    private AliPayStrategy() {
        if(aliPayStrategy != null) {
            throw new RuntimeException("此对象是单例模式，不允许再被创建");
        }
    }

    public static IPayStrategy getInstance() {
        return aliPayStrategy;
    }

    @Override
    public void pay() {
        System.out.println("支付宝支付.");
    }
}
