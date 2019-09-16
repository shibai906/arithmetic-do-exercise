package com.zhao.design.mode.singleton;

public class VolatileLazySinleton {

    private volatile static  VolatileLazySinleton volatileLazySinleton = null;
    private VolatileLazySinleton() {

    }
    public static VolatileLazySinleton getInstance() {

        return volatileLazySinleton == null ? (volatileLazySinleton =  new VolatileLazySinleton()) : volatileLazySinleton;
    }

}
