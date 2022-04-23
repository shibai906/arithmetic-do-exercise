package com.zhao.leetcode.bisai.bi288;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-10 11:23
 * @description
 **/
public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maximumProduct1(new int[]{92,36,15,84,57,60,72,86,70,43,16}, 62));
    }

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            queue.offer(queue.poll() + 1);
        }
        long prod = 1;
        for (int num : queue) {
            prod = prod * num % 1000000007;
        }
        return (int) prod;
    }

    public int maximumProduct1(int[] nums, int k) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (k > 0) {
            int start = 0;
            int num = map.get(nums[0]);
            num --;
            if (num == 0) {
                map.remove(nums[0]);
            } else {
                start += num;
                map.put(nums[0], num);
            }
            nums[start] = nums[start] + 1;
            map.put(nums[start], map.getOrDefault(nums[start], 0) + 1);
            k --;
        }

        long result = 1;
        for (int num : nums) {
            result *= num % (1000000007);
        }
        return (int) (result % (1000000007));

    }

}
