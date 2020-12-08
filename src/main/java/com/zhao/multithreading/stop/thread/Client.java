package com.zhao.multithreading.stop.thread;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-27 07:33
 **/
public class Client {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ThreadA());
        t.start();
        t.interrupt();

    }

}

class ThreadA implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("你好哇");
        }

    }
}
