package com.zhao.design.mode.prototype;

/**
 *  @program: DesignPatterns
 *  @desription: 声明use，createClone具体复用
 *  @author: zhaohuan
 *  @create: 2019-8-18 18:19
 */
public interface Product extends Cloneable{
    void use(int len);
    Product createClone();

}
