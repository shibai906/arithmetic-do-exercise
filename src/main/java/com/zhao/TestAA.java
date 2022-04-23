package com.zhao;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-09-08 23:46
 * @description
 **/
public class TestAA {
    public String s = "a";
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.lockInterruptibly();

    }
}
