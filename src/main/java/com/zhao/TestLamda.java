package com.zhao;


import java.time.LocalDate;
import java.util.concurrent.Semaphore;

/**
 *  测试lamda表达式
 */
public class TestLamda {

    private final static int EXPIRATION_TIME = 15 * 1000 * 24 * 60 * 60 ;

    public static void main(String[] args) throws Exception {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        Semaphore semaphore = new Semaphore(10);

        System.out.println(System.currentTimeMillis() + EXPIRATION_TIME);
    }


    private static Number test(int i , int j) {

        if(i % j == 0) {
            return i / j ;
        } else {
            return (float)i / j;
        }

    }


}
