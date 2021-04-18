package com.zhao.basis.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-01-24 10:20
 * @description
 **/
public class RandomTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        testSecureRandom();
    }

    public static void testRandom() {
        Random random = new Random();

        random.setSeed(10000L);

        for(int i = 0 ; i < 10 ; i ++) {
            System.out.println(random.nextInt(1000));
        }
        System.out.println("------------------");
        random = new Random();
        random.setSeed(10000L);
        for(int i = 0 ; i < 10 ; i ++) {
            System.out.println(random.nextInt(1000));
        }

    }


    public static void testSecureRandom() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(10000L);
        for(int i = 0 ; i < 10 ; i ++) {
            System.out.println(secureRandom.nextInt(1000));
        }
        System.out.println("-------------------");
        secureRandom = new SecureRandom();
        secureRandom.setSeed(10000L);
        for(int i = 0; i < 10 ; i ++) {
            System.out.println(secureRandom.nextInt(1000));
        }

    }

}
