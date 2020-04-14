package com.zhao.multithreading.jstack;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-07 14:41
 **/
public class Client {

    public static void main(String[] args) throws InterruptedException {

        for(int i = 0 ; i < 100 ; i ++) {
            new Thread(()->{
                try {
                    Sinle.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start(); ;
        }
        Thread.currentThread().join();

    }

}
