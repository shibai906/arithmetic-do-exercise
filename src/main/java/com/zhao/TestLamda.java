package com.zhao;

import java.util.Arrays;
import java.util.Optional;

/**
 *  测试lamda表达式
 */
public class TestLamda {

    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable(null);
        System.out.println(Arrays.toString("12:51".split(":")));

        new Thread(() -> System.out.println("Nihk"));

    }

    interface test {
        int ai(int a , int b);
    }

}
