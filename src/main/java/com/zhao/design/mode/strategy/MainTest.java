package com.zhao.design.mode.strategy;

public class MainTest {

    public static void main(String[] args) {

        // 执行上下文
        PayStrategyContext payStrategyContext = new PayStrategyContext();
        IPayStrategy payStrategy = null;
        // 1.支付宝支付
        payStrategy = AliPayStrategy.getInstance();
        payStrategyContext.setiPayStrategy(payStrategy);
        payStrategyContext.excutePay();
        // 2.银联支付
        payStrategy = EBankPayStrategy.getInstance();
        payStrategyContext.setiPayStrategy(payStrategy);
        payStrategyContext.excutePay();
        // 3.微信支付
        payStrategy = WexinPayStrategy.getInstance();
        payStrategyContext.setiPayStrategy(payStrategy);
        payStrategyContext.excutePay();
        // 4.小米支付
        payStrategy = MiPayStrategy.getInstance();
        payStrategyContext.setiPayStrategy(payStrategy);
        payStrategyContext.excutePay();

        payStrategy = PayStrategyUtils.getPayStrategy("Ali");
        payStrategy.pay();
        payStrategy = PayStrategyUtils.getPayStrategy("EBank");
        payStrategy.pay();
        payStrategy = PayStrategyUtils.getPayStrategy("Mi");
        payStrategy.pay();
        payStrategy = PayStrategyUtils.getPayStrategy("Wexin");
        payStrategy.pay();

    }

}
