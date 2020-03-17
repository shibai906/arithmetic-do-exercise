package com.zhao.multithreading.create.thread.runnable;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-16 11:27
 **/
public class Client {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

}
