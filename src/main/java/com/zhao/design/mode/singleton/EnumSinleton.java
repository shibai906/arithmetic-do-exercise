package com.zhao.design.mode.singleton;

/**
 *  这种方式是Effective Java作者Josh Bloch提倡的方式，它不仅能避免多线程同步问题，还能防止反序列化重新创建新的对象。可以说这是很坚强的壁垒。
 */
public enum  EnumSinleton {

    INSTANCE;

    private EnumSinleton() {

    }

    public void function() {

    }

}
