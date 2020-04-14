package com.zhao.multithreading.jstack;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-07 14:21
 **/
public class Sinle {

    private static Sinle sinle = null;

    private Sinle() {

    }

    public static Sinle getInstance() throws InterruptedException {
        if(sinle == null) {
            Thread.sleep(10000000);
            sinle = new Sinle();
        }
        return sinle;
    }

}
