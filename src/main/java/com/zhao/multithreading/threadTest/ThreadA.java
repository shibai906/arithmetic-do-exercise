package com.zhao.multithreading.threadTest;

public class ThreadA implements Runnable {

    Object object = new Object();
    @Override
    public  void run() {
        try {
            synchronized (object) {
                object.wait();
            }

            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            System.out.println("发生了异常，噫噫噫已");
            e.printStackTrace();
        }


    }
}
