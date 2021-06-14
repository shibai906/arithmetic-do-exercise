package com.zhao.leetcode.arr.easy;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-06-14 15:37
 * @description
 * 题目：分发饼干
 * 地址：https://leetcode-cn.com/problems/assign-cookies/
 * 题意：假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 解法：贪心算法
 *
 **/
public class DistributeBiscuits {

    public static void main(String[] args) {
        DistributeBiscuits db = new DistributeBiscuits();
        System.out.println(db.findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8}));
    }

    public int findContentChildren(int[] g, int[] s) {
        if(g.length == 0 || s.length == 0) {
            return 0;
        }
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);
        int i = 0, j = 0, result = 0;
        while (i < g.length && j < s.length) {
            int gnum = g[i];
            int snum = s[j ++];
            if(snum >= gnum) {
                result ++;
                i ++;
            }
        }
        return result;
    }

}
