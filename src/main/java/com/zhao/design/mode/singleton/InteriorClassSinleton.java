package com.zhao.design.mode.singleton;

/**
 * 你没有获取实例时,该类不会被加载,自然内部类也不会被加载,内部类不被加载该实例就不会被初始化
 */
public class InteriorClassSinleton {

    private InteriorClassSinleton() {

    }

    private static class SingletonHolder {
        private static  final  InteriorClassSinleton INSTANCE = new InteriorClassSinleton();
    }

    public static InteriorClassSinleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
