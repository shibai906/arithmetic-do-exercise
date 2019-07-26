package com.zhao.leetcode.arr;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumAdd {


    public static void main(String[] args) {
        twoSum(new int[]{3,2,4},6);
    }


    public static int[] twoSum(int[] nums, int target) {

        Arrays.sort(nums);
        int i = 0 , j = nums.length - 1;
        int[] arr = new int[2];
        while (i < j && nums[j] > target) {
            j -- ;
        }
        while (i < j) {
            int num = nums[i] + nums[j];
            if(num == target) {
                arr[0] = i;
                arr[1] = j;
                return arr;
            }
            if(num > target) {
                j -- ;
            }
            if(num < target) {
                i ++;
            }
        }
        return arr;

    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for(int i = 0 ; i < nums.length ; i ++) {
            int num = target - nums[i];
            if(map.containsKey(num)) {
                arr[0] = map.get(num);
                arr[1] = i;
                return arr;
            }
            map.put(nums[i],i);
        }

        return arr;

    }




}
