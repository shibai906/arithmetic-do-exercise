package com.zhao.multithreading.deadlock;

import org.apache.log4j.Logger;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-08 00:09
 **/
public class A {

    private static final Logger logger = Logger.getLogger(A.class);

    public A() {
        try {
            logger.info("AAA");
        } catch (Exception e) {
            logger.error("AAAAA",e);
        }

    }
}
