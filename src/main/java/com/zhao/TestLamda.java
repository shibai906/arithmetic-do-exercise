package com.zhao;


import java.util.Scanner;
import java.time.LocalDate;
import java.util.concurrent.Semaphore;

/**
 *  测试lamda表达式
 */
public class TestLamda {

    public static void main(String[] args) {
        TestLamda tl = new TestLamda();
        tl.twoSum(new int[]{2,7,11,15} , 9);
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
