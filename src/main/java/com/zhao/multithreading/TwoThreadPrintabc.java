package com.zhao.multithreading;

/**
 * 两个线程同时交替打印abc到z，顺序一致，交替打印
 */
public class TwoThreadPrintabc {
    static volatile char ch = 'a';
    static volatile boolean flag = true;

    public static void main(String[] args) {
        Object object = new Object();

        new Thread(() -> {
            while (true) {
                if (flag) {
                    System.out.println(Thread.currentThread() + " .... " + ch);
                    ch++;
                    flag = false;
                    if (ch >= 'z') {
                        break;
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (!flag) {
                    System.out.println(Thread.currentThread() + " .... " + ch);
                    ch++;
                    flag = true;
                    if (ch >= 'y') {
                        break;
                    }
                }
            }
        }).start();

    }


}
