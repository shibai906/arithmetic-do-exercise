package com.zhao.arithmetic.sort;

import java.util.Arrays;

/**
 * @program: arithmetic-do-exercise
 * @description 计数排序，适用返回，排序年龄，排序成绩等，数之前范围确定的，不是特别大的场景，他的时间复杂度为n
 * @author: zhaohuan
 * @create: 2020-04-09 00:00
 **/
public class CountSort {

    public static void main(String[] args) {
        int arr[] = new int[1000];
        for(int i = 0 ; i < 1000 ; i ++) {
            arr[i] = (int) (Math.random() * 100);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[]) {
        if(arr == null) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for(int i = 1 ; i < arr.length ; i ++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        int newArr[] = new int[max - min + 1];
        for(int i = 0 ; i < arr.length ; i ++) {
            newArr[arr[i] - min] ++ ;
        }
        int num = 0 ;
        for(int i = 0 ; i < newArr.length ; i ++) {
            for(int j = 0 ; j < newArr[i]; j ++) {
                arr[num ++] = i + min;
            }
        }


    }

}
