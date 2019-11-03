package com.zhao.multithreading.join.join1;

public class ThreadJoin1 implements Runnable {

    private String name;
    public ThreadJoin1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10 ; i ++) {
            System.out.println(Thread.currentThread().getName() + "---------" + name);
        }
    }
}
