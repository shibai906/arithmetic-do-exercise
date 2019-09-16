package com.zhao.leetcode.integer;

import java.util.Arrays;

public class ChopCake {

    public static void main(String[] args) {
        System.out.println(prinft(4,1,1,2));
    }

    public static int prinft(int x, int y , int z , int k) {
        if(x - 1 + y - 1 + z - 1 <= k) {
            return x * y * z;
        }
        int[] arr = new int[]{x,y,z};
        Arrays.sort(arr);
        int min = 1 , mid = 1 , max = 1 ;
        while (k > 0) {
            if(arr[0] > 1 && k >0) {
                k -- ;
                min ++ ;
                arr[0] -- ;
            }
            if(arr[1] > 1 && k > 0) {
                k -- ;
                mid ++ ;
                arr[1] -- ;
            }
            if(arr[2] > 1 && k > 0) {
                k -- ;
                max ++;
                arr[2] -- ;
            }
        }
        return min * mid * max;

    }

}
