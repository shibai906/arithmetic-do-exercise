package com.zhao.leetcode.bisai.bi286;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-27 10:31
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-286/problems/find-the-difference-of-two-arrays/
 * 题目：给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 *
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 **/
public class NoSame {

    public static void main(String[] args) {
        NoSame noSame = new NoSame();
        noSame.findDifference(new int[]{1,2,3,3}, new int[]
                {1,1,2,2});
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // 大神做法
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set1.remove(num);
            set2.add(num);
        }
        for (int num : nums1) {
            set2.remove(num);
        }

        return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));


    }

}
