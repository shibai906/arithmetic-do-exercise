package com.zhao.multithreading.deadlock;

import org.apache.log4j.Logger;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-08 00:09
 **/
public class Client {

    private static final Logger logger = Logger.getLogger(A.class);

    public static void main(String[] args) {
        for(int i = 0 ; i < 100 ; i ++) {
            new Thread(() -> {
                logger.info(new Client());
            }).start(); ;
            new A();
        }

    }

    public String toString() {
        logger.info("[B.toString]");
        new A();
        return "[B.toString] finish";
    }

}
