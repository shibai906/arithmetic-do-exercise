package com.zhao;


import java.time.LocalDate;

/**
 *  测试lamda表达式
 */
public class TestLamda {

    private final static int EXPIRATION_TIME = 15 * 1000 * 24 * 60 * 60 ;

    public static void main(String[] args) throws Exception {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
    }


}
