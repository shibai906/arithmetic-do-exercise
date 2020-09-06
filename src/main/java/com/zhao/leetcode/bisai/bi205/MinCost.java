package com.zhao.leetcode.bisai.bi205;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-09-06 11:40
 * @description
 * 地址：https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 * 题目：避免重复字母的最小删除成本
 * 描述：给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 *      返回使字符串任意相邻两个字母不相同的最小删除成本。
 *      请注意，删除一个字符后，删除其他字符的成本不会改变。
 *
 **/
public class MinCost {

    public static void main(String[] args) {
        MinCost mc = new MinCost();
        System.out.println(mc.minCost("aaabbbabbbb",new int[]{3,5,10,7,5,3,5,5,4,8,1}));
    }

    public int minCost(String s, int[] cost) {
        if(s == null || s.length() == 0 || s.length() != cost.length) {
            return 0;
        }
        int minCost = 0 ;
        char pre = s.charAt(0);
        int min = 0;
        for(int i = 1 ; i < s.length() ; i ++ ) {
            if(s.charAt(i) == pre) {
                minCost += Math.min(cost[i] , cost[min]);
                min = cost[i] > cost[min] ? i : min;
            } else {
                pre = s.charAt(i);
                min = i;
            }

        }
        return minCost;


    }

}
