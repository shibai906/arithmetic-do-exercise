package com.zhao.arithmetic.ms.didi;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-14 22:52
 * 题目：从数组里面，找出相同的数，相同个数最多的数排在最前面
 **/
public class Sort {

    public static int[] arr(int arr[]) {
        if(arr == null) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i ++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) +1);
        }
        int newArr[][] = new int[2][map.size()];
        int i = 0 ;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            newArr[0][i] = entry.getKey();
            newArr[1][i ++] = entry.getValue();
        }
        sort(newArr);
        int result[] = new int[newArr[0].length];
        for(i = 0 ; i < newArr[0].length ; i ++) {
            result[i] = newArr[0][i];
        }
        return result;

    }

    private static void sort(int[][] arr) {

        digui(arr, 0 , arr[0].length - 1);

    }

    private static void digui(int[][] arr , int start , int end) {

        if(start < end) {
            int mid = ( start + end ) / 2;
            digui(arr , start , mid);
            digui(arr , mid + 1 , end);
            paixu(arr , start , mid , end);
        }

    }
    private static void paixu(int[][] arr, int start , int mid, int end) {

        int[][] newArr = new int[2][end-start + 1];
        int i = start , j = mid + 1 , num = 0;
        while (i <= mid && j <= end) {
            if(arr[1][i] > arr[1][j]) {
                assign(newArr,num ++ , arr , i ++);
            } else if(arr[1][i] < arr[1][j]) {
                assign(newArr , num ++ , arr , j ++);
            } else {
                assign(newArr , num ++ , arr , i ++);
                assign(newArr , num ++ , arr , j ++);
            }
        }
        while (i <= mid) {
            assign(newArr , num ++ , arr , i ++);
        }
        while (j <= end) {
            assign(newArr , num ++ , arr , j ++);
        }
        num = 0;
        for(; start <= end ; start ++) {
            assign(arr , start , newArr , num ++);
        }

    }

    private static void assign(int[][] newArr , int newArrLen , int[][] arr , int arrLen) {
        newArr[0][newArrLen] = arr[0][arrLen];
        newArr[1][newArrLen] = arr[1][arrLen];
    }

}
