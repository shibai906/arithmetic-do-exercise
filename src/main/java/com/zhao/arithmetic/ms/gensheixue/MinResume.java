package com.zhao.arithmetic.ms.gensheixue;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @description 习题地址及其详情：https://app.yinxiang.com/fx/eebf89b7-733c-417d-95bd-86dfb5d9b82c
 * @author: zhaohuan
 * @create: 2020-04-21 09:36
 **/
public class MinResume {

    int min = 0;
    public static void main(String[] args) {

    }

    public void getMinNum(int arr[][]) {
        min = arr.length;
        Set<Integer> allNum = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i ++) {
            for(int j = 0 ; j < arr[i].length ; j ++) {
                allNum.add(arr[i][j]);
            }
        }
        jianzhi(arr , 0 , allNum);
    }

    private int jianzhi(int[][] arr, int start,  Set<Integer> allNum) {

        if(allNum.size() == 0) {
            return 1;
        }

        for(int i = start ; i < arr.length ; i ++) {
            Set<Integer> set = new HashSet<>(allNum);
            for(int j = 0 ; j < arr[i].length ; j ++) {
                set.remove(arr[i][j]);
            }
            int num = jianzhi(arr,i + 1 , set);
            if(start == 0) {
                if(min > num) {
                    min = num;
                }

            }
            return num + 1;
        }
        return 0;
    }

}
