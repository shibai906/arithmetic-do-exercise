package com.zhao.arithmetic.ms.shopee;

import java.util.Scanner;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-06-30 12:12
 * @description
 * 虾皮笔试题一： 合并两个数组
 **/
public class MergeTwoArr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Click HELP above to see examples of handling input/debug/output
        // INPUT: int n = in.nextInt();
        // DEBUG: System.out.println(n);
        // OUTPUT: System.out.println(result);

        // Write the code to solve the problem below,
        // format the "result" as specified in the problem statement
        // and finally, write the result to stdout
        // IMPORTANT: Remove all debug statements for final submission

        String string1 = in.next();
        String string2 = in.next();
        String strs1[] = string1.split(",");
        String strs2[] = string2.split(",");

        int arr1[] = new int[strs1.length];
        int arr2[] = new int[strs2.length];

        for(int i = 0 ; i < arr1.length ; i ++) {
            arr1[i] = Integer.parseInt(strs1[i]);
        }

        for(int i = 0 ; i < arr2.length ; i ++) {
            arr2[i] = Integer.parseInt(strs2[i]);
        }
        int result[] = sortByToArr(arr1, arr2);
        if(result == null) {
            return ;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < result.length ; i ++) {
            sb.append(result[i]).append(",");
        }

        System.out.println(sb.substring(0 , sb.length() - 1).toString());

    }

    public static int[] sortByToArr(int arr1[] , int arr2[]) {
        if(arr1 == null) {
            return arr2;
        }
        if(arr2 == null) {
            return arr1;
        }
        int result[] = new int[arr1.length + arr2.length];

        int i = 0 , i1 = 0 , i2 = 0 ;

        for( ; i1 < arr1.length && i2 < arr2.length ;) {
            if(arr1[i1] < arr2[i2]) {
                result[i ++] = arr1[i1 ++];
            }else if(arr1[i1] > arr2[i2]) {
                result[i ++] = arr2[i2 ++];
            } else{
                result[i ++] = arr1[i1 ++];
                result[i ++] = arr2[i2 ++];
            }

        }

        for(; i1 < arr1.length ;) {
            result[i ++] = arr1[i1 ++];
        }
        for(; i2 < arr2.length ;) {
            result[i ++] = arr2[i2 ++];
        }
        return result;
    }

}
