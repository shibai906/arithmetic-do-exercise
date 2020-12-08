package com.zhao;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-27 11:11
 * @description
 **/
public class TestToutiao {

    public void fun(int[] arr) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i ++) {
            while (arr[i] - 1 != i) {
                if(arr[i] == arr[arr[i] - 1]) {
                    list.add(arr[i]);
                    break;
                }
                swap(arr, i, arr[i] - 1);
            }
        }


    }

    public void swap(int arr[] , int i , int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
