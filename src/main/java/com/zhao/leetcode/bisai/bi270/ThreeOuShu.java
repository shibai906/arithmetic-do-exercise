package com.zhao.leetcode.bisai.bi270;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-12-05 10:33
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-270/problems/finding-3-digit-even-numbers/
 * 题目：找出 3 位偶数
 *  给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 *
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 *
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 *
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 **/
public class ThreeOuShu {

    public static void main(String[] args) {
        ThreeOuShu ouShu = new ThreeOuShu();
        System.out.println(Arrays.toString(ouShu.findEvenNumbers(new int[]{2,1,3,0})));
    }

    public int[] findEvenNumbers(int[] digits) {
        if (digits == null || digits.length <= 0) {
            return null;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 0 ; i < digits.length; i ++) {
            if (digits[i] % 2 == 0) {
                findEvenNumbers(digits, i, digits[i], set);
            }
        }
        int arr[] = new int[set.size()];
        List<Integer> list = Lists.newArrayList(set);
        for (int i = 0 ; i < list.size() ; i ++) {
            arr[i] = list.get(i);
        }
        return arr;

    }

    private void findEvenNumbers(int[] digits, int zhanwei1, int digit, Set<Integer> set) {
        for (int i = 0 ; i < digits.length; i ++) {
            if (zhanwei1 != i) {

                findEvenNumbers(digits, zhanwei1, i, digits[i] * 10 + digit, set);
            }
        }
    }

    private void findEvenNumbers(int[] digits, int zhanwei1, int zhanwei2, int digit, Set<Integer> set) {
        for (int i = 0 ; i < digits.length; i ++) {
            if (zhanwei1 != i && zhanwei2 != i && digits[i] != 0) {
                set.add(digits[i] * 100 + digit);
            }
        }
    }

}
