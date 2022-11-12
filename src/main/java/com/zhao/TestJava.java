package com.zhao;


import com.zhao.io.Test;

import java.util.HashMap;
import java.util.Map;

public class TestJava {


    public static void main(String[] args) {
        TestJava testJava = new TestJava();
        testJava.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3);
    }

    public long maximumSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap();
        if (nums.length < k) {
            return 0;
        }

        long add = 0;
        long result = 0;
        for (int i = 0; i < k; i ++) {
            add += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.size() == k) {
            result = add;
        }

        for (int i = k; i < nums.length; i ++) {
            add += nums[i];
            add -= nums[i - k];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            Integer num = map.get(nums[i - k]);
            if (num == null) {
                System.out.println();
            }
            if (num == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], num - 1);
            }
            if (map.size() == k && add > result) {
                result = add;
            }
        }
        return result;
    }


}









