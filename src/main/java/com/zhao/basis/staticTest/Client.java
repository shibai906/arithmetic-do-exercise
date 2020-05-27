package com.zhao.basis.staticTest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-05-11 17:14
 **/
public class Client {


    public static void main(String[] args) {

        try {
            TestModel testModel = new TestModel();
        } catch (ExceptionInInitializerError e) {

        }
        System.out.println("试试");

    }

}
