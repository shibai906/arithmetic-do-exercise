package com.zhao.basis.classloader;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-05-07 17:38
 **/
public class TestFunction {

    public static void fun() {
        System.out.println("哈哈哈哈");
    }

    static  {
        System.out.println("TestFunction执行了");
    }

    public void test() {
        System.out.println("测试方法");
    }

}
