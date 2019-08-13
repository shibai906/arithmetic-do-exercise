package com.zhao.leetcode.arr;

/**
 *  地址： https://leetcode-cn.com/problems/minimum-cost-to-merge-stones/
 *   合并石头的最低成本
 *   有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 *
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 *
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1
 *
 */
public class MergeStone {

    public static void main(String[] args) {

    }

    public static int mergeStones(int[] stones, int K) {
        int len = stones.length;
        if(len == 0) {
            return -1;
        }
        if(len == 1) {
            return 0;
        }
        if( K < 2 || K != 2 || len % (K - 1) != 1) {
            return -1;
        }
        return 0;
    }

}
