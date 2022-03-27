package com.zhao.leetcode.bisai.bi286;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-27 10:50
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-286/problems/minimum-deletions-to-make-array-beautiful/
 * 题目：美化数组的最少删除数
 * 描述：给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
 *
 * nums.length 为偶数
 * 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
 * 注意，空数组同样认为是美丽数组。
 *
 * 你可以从 nums 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。
 *
 * 返回使 nums 变为美丽数组所需删除的 最少 元素数目。
 **/
public class BeautifulNun {

    public static void main(String[] args) {
        BeautifulNun bn = new BeautifulNun();
        System.out.println(bn.minDeletion(new int[]{1,1,2,2,3,3}));
    }

    public int minDeletion(int[] nums) {

        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i ++) {
            if (list.size() % 2 == 1 || nums[i] != nums[i + 1]) {
                list.add(nums[i]);
            } else {
                result ++;
            }
        }
        if (list.size() % 2 != 1) {
            result ++;
        }
        return result;
    }

}
