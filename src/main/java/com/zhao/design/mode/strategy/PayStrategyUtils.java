package com.zhao.design.mode.strategy;

public class PayStrategyUtils {

    public static IPayStrategy getPayStrategy(String payType) {

        try {
            // 定义全路劲
            String path = "com.zhao.design.mode.strategy." + payType.concat("PayStrategy");
            // 反射，类加载器
            Class<?> clazz = Class.forName(path);
            // 调用instance()方法获取单例对象
            IPayStrategy instance = (IPayStrategy) clazz.getDeclaredMethod("getInstance").invoke(null,null);
            return instance;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Load [" + payType.concat("Strategy") + "] Error",e);
        }

    }

}
