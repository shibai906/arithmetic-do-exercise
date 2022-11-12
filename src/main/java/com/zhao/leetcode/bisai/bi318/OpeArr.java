package com.zhao.leetcode.bisai.bi318;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-11-06 13:42
 * @description
 * 地址：https://leetcode.cn/problems/apply-operations-to-an-array/description/
 * 题目：对数组执行操作
 * 描述：
 *  给你一个下标从 0 开始的数组 nums ，数组大小为 n ，且由 非负 整数组成。
 *
 *  你需要对数组执行 n - 1 步操作，其中第 i 步操作（从 0 开始计数）要求对 nums 中第 i 个元素执行下述指令：
 *
 *  如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，nums[i + 1] 的值变成 0 。否则，跳过这步操作。
 *  在执行完 全部 操作后，将所有 0 移动 到数组的 末尾 。
 *
 *  例如，数组 [1,0,2,0,0,1] 将所有 0 移动到末尾后变为 [1,2,1,0,0,0] 。
 *      返回结果数组。
 *
 *  注意 操作应当 依次有序 执行，而不是一次性全部执行。
 **/
public class OpeArr {

    public int[] applyOperations(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1] && nums[i] != 0) {
                nums[index ++] = nums[i] * 2;
                nums[i] = 0;
            } else if (nums[i - 1] != 0) {
                nums[index ++] = nums[i - 1];
            }
        }
        if (nums[nums.length - 1] != 0) {
            nums[index ++] = nums[nums.length - 1] ;
        }

        for (; index < nums.length; index ++) {
            nums[index] = 0;
        }
        return nums;
    }
}
