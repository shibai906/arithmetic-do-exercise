package com.zhao.leetcode.StringStudy.medium;

import java.util.Arrays;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-21 23:18
 * @description
 * 题目：寻找排列
 * 描述：现在给定一个只由字符 'D' 和 'I' 组成的 秘密签名。
 * 'D' 表示两个数字间的递减关系，'I' 表示两个数字间的递增关系。并且 秘密签名 是由一个特定的整数数组生成的，
 * 该数组唯一地包含 1 到 n 中所有不同的数字（秘密签名的长度加 1 等于 n）。例如，秘密签名 "DI" 可以由数组 [2,1,3] 或 [3,1,2] 生成，
 * 但是不能由数组 [3,2,4] 或 [2,1,3,4] 生成，因为它们都不是合法的能代表 "DI" 秘密签名 的特定串。
 * 现在你的任务是找到具有最小字典序的 [1, 2, ... n] 的排列，使其能代表输入的 秘密签名。
 *
 * 地址：https://leetcode-cn.com/problems/find-permutation/
 *
 * 题解： 主要用到的思想，贪心算法。注意判断边界
 **/
public class FindPermutation {

    public static void main(String[] args) {
        FindPermutation fp = new FindPermutation();
        System.out.println(Arrays.toString(fp.findPermutation("DDIIDI")));
    }

    public int[] findPermutation(String s) {

        int max = s.length() + 1 , min = 1;
        int[] arr = new int[max];
        int start = -1 ;
        arr[0] = 1 ;
        for(int i = 0 ; i < s.length() ; i ++) {
            arr[i + 1] = i + 2;
            if(s.charAt(i) == 'I') {
                if(start != i ) {
                    reverse(arr,start + 1 , i);
                }
                start = i;
            }
        }
        if(s.charAt(s.length() - 1) == 'D') {
            reverse(arr ,  start + 1 , arr.length - 1);
        }
        return arr;
    }

    private void reverse(int arr[] , int l , int r) {
        if(l >= r ) {
            return ;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverse(arr , l + 1 , r - 1);
    }

}
