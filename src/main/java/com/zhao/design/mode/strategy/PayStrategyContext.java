package com.zhao.design.mode.strategy;

public class PayStrategyContext {

    private IPayStrategy iPayStrategy;

    public PayStrategyContext() {

    }
    /**
     * 执行支付
     */
    public void excutePay() {
        if(null == iPayStrategy) {
            throw new RuntimeException("支付策略未分配");
        }
        iPayStrategy.pay();
    }

    public IPayStrategy getiPayStrategy() {
        return iPayStrategy;
    }

    public void setiPayStrategy(IPayStrategy iPayStrategy) {
        this.iPayStrategy = iPayStrategy;
    }
}
