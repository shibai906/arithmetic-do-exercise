package com.zhao.leetcode.bisai.bi213;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-01 10:51
 * @description
 * 地址： https://leetcode-cn.com/contest/weekly-contest-213/problems/check-array-formation-through-concatenation/
 * 题目：能否连接形成数组
 * 描述：给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 *      如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 **/
public class FromArray {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 100000 ; i ++) {
            String name = RandomStringUtils.random(15, true, false);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {

        if(arr == null && pieces == null) {
            return true;
        }

        for(int i = 0 ; i < pieces.length ; i ++) {
            for(int j = 0 ; j < pieces[i].length ; j ++) {
                int[] piece = new int[pieces[i].length];
                System.arraycopy(pieces[i], 0, piece, 0, pieces[i].length);
                if(!arrContainPieces(arr,piece)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean arrContainPieces(int arr[], int piece[]) {
        int num = 0;
        for(int i = 0 ; i < arr.length ; i ++) {
            if(num == piece.length) {
                return true;
            }
            if(arr[i] == piece[num]) {
                num ++;
            } else {
                num = 0;
            }
        }
        if(num == piece.length) {
            return true;
        }
        return false;
    }

}
