package com.zhao.leetcode.bisai.bi216;


/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-22 10:59
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-216/problems/ways-to-make-a-fair-array/
 * 题目：生成平衡数组的方案数
 * 描述：给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 *      比方说，如果 nums = [6,1,7,4,1] ，那么：
 *      选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 *      选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 *      选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 *      如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 *
 *      请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 **/
public class MinString {

    public static void main(String[] args) {
        System.out.println((char) ('a' + 20));
        MinString ms = new MinString();
        System.out.println(ms.getSmallestString(3,27));
    }

    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            k = getChar(sb, k, n - i - 1);
        }

        return sb.toString();

    }

    private int getChar(StringBuilder sb, int k, int cha) {

        if(cha == 0) {
            sb.append((char) (k + 'a' - 1));
            return 0;
        }
        int add = cha * ('z' - 'a' + 1);
        if(add >= k) {
            sb.append('a');
            return k - 1;
        }
        if(k > add) {
            sb.append((char) (k - add + 'a' - 1));
            return add;
        }

        return 0;
    }

}
