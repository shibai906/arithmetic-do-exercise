package com.zhao.arithmetic.ms.shopee;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-06-27 20:20
 * @description
 * leetcode 地址： https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 * 公司：虾皮
 * 题目： 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * 思路1： 使用集合方式，自己使用的方式不可行，使用以下算法，最起码能做出来，由于有排序，所有时间复杂度是nlogN
 **/
public class MaxByThree {

    public static void main(String[] args) {
        MaxByThree three = new MaxByThree();
        System.out.println(three.maxSumDivThreeByDp(3,6,5,1,8));
    }

    /**
     * 使用数学的方法，为啥我就想不到里，我太垃圾了吧，记录下来。
     * @param nums
     * @return
     */
    public int maxSumDivThree(int ... nums) {

        if(nums == null) {
            return 0;
        }

        List<Integer> one = new ArrayList<>(); // 存放 mod3=1 的数
        List<Integer> two = new ArrayList<>(); // 存放 mod3=2 的数

        int sum = 0;
        for (int e : nums) {
            if (e % 3 == 1) one.add(e);
            if (e % 3 == 2) two.add(e);
            sum += e;
        }

        Collections.sort(one);
        Collections.sort(two);

        int res = sum % 3, ans = 0;
        if(res == 0) {
            return sum;
        }
        if(res == 1) {
            if(one.size() > 0) {
                ans = sum - one.get(0);
            }
            if(two.size() > 1) {
                ans = Math.max(ans , sum - two.get(0) - two.get(1));
            }
        }
        if(res == 2) {
            if(one.size() > 1) {
                ans = sum - one.get(0) - one.get(1);
            }
            if(two.size() > 0) {
                ans = Math.max(ans , sum - two.get(0));
            }
        }
        return ans;
    }

    /**
     * 此方法遍历一次即可，就能找出所有的值
     * @param nums
     * @return
     */
    public int maxSumDivThreeFunTwo(int ... nums) {

        if(nums == null) {
            return 0 ;
        }

        int one1 = 0;
        int one2 = 0;
        int two1 = 0;
        int two2 = 0;

        int add = 0 ;
        for(int num : nums) {
            if(num % 3 == 1) {
                if(one1 == 0 || num < one1) {
                    one2 = one1;
                    one1 = num;
                } else if ( one2 == 0 || num < one2) {
                    one2 = num;
                }
            }
            if(num % 3 == 2) {
                if(two1 == 0 || num < two1) {
                    two2 = two1;
                    two1 = num;
                } else if (two2 == 0 || num < two2) {
                    two2 = num;
                }
            }
            add += num;
        }
        int res = add % 3 , ans = 0;
        if(res == 0) {
            return add;
        } else if(res == 1) {
            if(two1 > 0 && two2 > 0) {
                ans = Math.max(ans , add - two1 - two2);
            }
            if(one1 > 0) {
                ans = Math.max(ans , add - one1);
            }
            return ans;
        } else {
            if(one1 > 0 && one2 > 0) {
                ans = Math.max(ans , add - one1 - one2);
            }
            if(two1 > 0) {
                ans = Math.max(ans , add - two1);
            }
            return ans;
        }
    }

    public int maxSumDivThreeByDp(int ... nums) {
        int[] dp = new int[3];
        dp[nums[0] % 3] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int[] temp = new int[3];
            for (int k = 0; k < 3; k++)
                temp[k] = dp[k];
            for (int j = 0; j < 3; j++) {
                int index = (temp[j] + nums[i]) % 3;
                dp[index] = Math.max(dp[index], temp[j] + nums[i]);
            }
        }
        return dp[0];
    }


}

/*
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        dp[nums[0] % 3] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int[] temp = new int[3];
            for (int k = 0; k < 3; k++)
                temp[k] = dp[k];
            for (int j = 0; j < 3; j++) {
                int index = (temp[j] + nums[i]) % 3;
                dp[index] = Math.max(dp[index], temp[j] + nums[i]);
            }
        }
        return dp[0];
    }
*/

/**
 * public int maxSumDivThree(int[] nums) {
 *             int[] dp = new int[3];
 *             dp[nums[0] % 3] = nums[0];
 *             for (int i = 1; i < nums.length; i++) {
 *                 int[] temp = new int[3];
 *                 for (int k = 0; k < 3; k++)
 *                     temp[k] = dp[k];
 *                 for (int j = 0; j < 3; j++) {
 *                     int index = (temp[j] + nums[i]) % 3;
 *                     dp[index] = Math.max(dp[index], temp[j] + nums[i]);
 *                 }
 *             }
 *             return dp[0];
 *         }
 */
