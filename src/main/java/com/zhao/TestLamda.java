package com.zhao;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 *  测试lamda表达式
 */
public class TestLamda {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String name = "赵欢";
        String name1 = "赵欢";
        System.out.println(name == name1);


    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers == null || numbers.length == 0) {
            return result;
        }
        int start = 0 , end = numbers.length - 1 , add = numbers[start] + numbers[end];
        while(start < end) {
            if(add > target) {
                end -- ;
            }
            if(add < target) {
                start ++ ;
            }
            if(add == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            add = numbers[start] + numbers[end];
        }
        return result;
    }


}
