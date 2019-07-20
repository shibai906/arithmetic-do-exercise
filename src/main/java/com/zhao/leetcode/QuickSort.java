package com.zhao.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for(int i = 0 ; i < 100 ; i ++) {
            arr[i] = (int) (Math.random() * 1000 + 1);
        }
//        quick(arr,0 , arr.length - 1);
        noRecursionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void quick(int[] arr , int min , int max) {
        if(min >= max ) {
            return;
        }
        int i = min, j = max ;
        while (i < j) {
            for(; j > i ; j --) {
                if(arr[j] < arr[i] ) {
                    int temp = arr[j] ;
                    arr[j] = arr[i] ;
                    arr[i] = temp;
                    i ++ ;
                    break;
                }
            }
            for(; j > i ; i ++) {
                if(arr[j] < arr[i]) {
                    int temp = arr[j] ;
                    arr[j] = arr[i];
                    arr[i] = temp;
                    j -- ;
                    break;
                }
            }
        }

        quick(arr , min , i - 1);
        quick(arr , i + 1 , max);

    }

    public static void noRecursionSort(int arr[]) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int max = stack.pop(),min = stack.pop() ;
            int i = min , j = max ;
            while (i < j) {
                for(; j > i ; j --) {
                    if(arr[j] < arr[i] ) {
                        int temp = arr[j] ;
                        arr[j] = arr[i] ;
                        arr[i] = temp;
                        i ++ ;
                        break;
                    }
                }
                for(; j > i ; i ++) {
                    if(arr[j] < arr[i]) {
                        int temp = arr[j] ;
                        arr[j] = arr[i];
                        arr[i] = temp;
                        j -- ;
                        break;
                    }
                }
            }
            if(min < max) {
                stack.push(min);
                stack.push(i - 1);
                stack.push(i + 1);
                stack.push(max);
            }

        }
    }

}
