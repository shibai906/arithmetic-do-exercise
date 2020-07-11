package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-05 12:34
 * @description
 * 题目： 火柴拼正方形
 * 描述： 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * 习题地址： https://leetcode-cn.com/problems/matchsticks-to-square/
 * 做法： 因为正方型四个边相等，然后只要下面数字能组成四个相同的数字即可。
 * 难点： 如何找几个数合起来的值等于特定值，还需要注意的是，先用大数，在用小数，要不然会存在，两个小数之和等于大数，后面的还得再拆分
 **/
public class MatchJointSquare {

    private boolean find = false;

    public static void main(String[] args) {
        MatchJointSquare jointSquare = new MatchJointSquare();
        System.out.println(jointSquare.makesquare(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
    }

    public boolean makesquare(int... nums) {
        if(nums == null || nums.length < 4) {
            return false;
        }
        Integer sortNum[] = new Integer[nums.length];
        for(int i = 0 ; i < nums.length ; i ++) {
            sortNum[i] = nums[i];
        }
        Arrays.sort(sortNum,Collections.reverseOrder());
        for(int i = 0 ; i < nums.length ; i ++) {
            nums[i] = sortNum[i];
        }
        int max = 0;
        int sum = 0 ;
        for(int num : nums) {
            sum += num;
            if(max < num) {
                max = num;
            }
        }
        if(sum % 4 > 0) {
            return false;
        }
        int brim = sum / 4 ;
        if(max > brim) {
            return false;
        }
        List<Integer> recordNumber = new ArrayList<>();
        for(int i = 0 ; i < 4 ; i ++ ) {
            findBrim( 0 ,nums , brim , recordNumber);
            if(!find) {
                return false;
            }
            find = false;
        }
        return true;
    }

    private void findBrim( int start , int[] nums, int brim , List<Integer> recordNumber) {
        if(find || brim < 0) {
            return;
        }
        if(brim == 0) {
            find = true;
            for(int num : recordNumber) {
                nums[num] = 0;
            }
            return ;
        }
        for( ; start < nums.length ; start ++) {
            if(nums[start] != 0) {
                recordNumber.add(start);
                findBrim(start + 1 , nums , brim - nums[start] , recordNumber);
                recordNumber.remove(recordNumber.size() - 1);
            }
        }

    }


}
