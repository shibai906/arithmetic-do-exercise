package com.zhao.design.mode.bridge;

/**
 * @author zhaohuan
 * @Date 19-8-15
 * @Time 下午7:13
 * @Comments 实现化角色：接口或抽象类，定义角色必须的行为和属性
 */
public interface Implementor {

    /**
     * 实例方法，实现抽象部分需要的某些具体功能
     */
    public void doSomething();

}
