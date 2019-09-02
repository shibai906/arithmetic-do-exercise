package com.zhao.io;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        System.out.println(RandomStringUtils.random(15, true, false));
        System.out.println(Arrays.toString("1.2.3".split("\\.")));
    }

}
