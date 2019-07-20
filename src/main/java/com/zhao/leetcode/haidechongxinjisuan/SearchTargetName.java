package com.zhao.leetcode.haidechongxinjisuan;

public class SearchTargetName {

    public static void main(String[] args) {

    }

    public static int[] get(int[] arr , int target) {
        int[] result = {-1,-1};
        int len = arr.length;
        if(len < 1) {
            return result;
        }
        int i = 0 , j = len;

        while (arr[j] > target) {
            j -- ;
        }
        while (i < j) {
            if(arr[i] >= target) {
                return result;
            }
            int num = arr[i] + arr[j];
            if(num < target) {
                i ++ ;
            } else if(num > target) {
                j --;
            } else {
                result[0] = i ;
                result[1] = j;
            }
        }
        return result;
    }

}
