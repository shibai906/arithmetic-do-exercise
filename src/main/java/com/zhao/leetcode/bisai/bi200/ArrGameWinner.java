package com.zhao.leetcode.bisai.bi200;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-02 10:46
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-200/problems/find-the-winner-of-an-array-game/
 * 题目：找出数组游戏的赢家
 * 描述：给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 *      每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，
 *      较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 *      返回赢得比赛的整数。
 *      题目数据 保证 游戏存在赢家。
 **/
public class ArrGameWinner {

    public static void main(String[] args) {
        ArrGameWinner agw = new ArrGameWinner();
        agw.getWinner(new int[]{1,25,35,42,68,70} , 2) ;
    }

    public int getWinner(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0) {
            return 0;
        }
        int result = arr[0] ;
        if(arr.length > k) {
            int continuous = 0 ;
            for(int i = 1 ; i < arr.length ; i ++) {
                if(result > arr[i]) {
                    continuous ++ ;
                    if(continuous == k) {
                        return result;
                    }
                } else {
                    result = arr[i] ;
                    continuous = 1;
                    if(continuous == k) {
                        return result;
                    }
                }
                if(i == arr.length - 1) {
                    i = 0;
                }
            }
        }
        for(int i = 1 ; i < arr.length ; i ++) {
            result = Math.max(result , arr[i]);
        }
        return result;

    }

}
