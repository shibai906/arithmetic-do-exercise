package com.zhao.leetcode.arr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  地址： https://leetcode-cn.com/problems/shuffle-an-array/
 *  打乱数组
 *  打乱一个没有重复元素的数组。
 *  // 以数字集合 1, 2 和 3 初始化数组。
 *  int[] nums = {1,2,3};
 *  Solution solution = new Solution(nums);
 *  // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 *  solution.shuffle();
 *  // 重设数组到它的初始状态[1,2,3]。
 *  solution.reset();
 *  // 随机返回数组[1,2,3]打乱后的结果。
 *  solution.shuffle();
 */
public class DisorganizeArr {

    // 暴力算法，
    /*List<Integer> list = new ArrayList<>();

    private Random rand = new Random();

    public DisorganizeArr(int[] nums) {
        for(int i = 0 ; i < nums.length ; i ++) {
            list.add(nums[i]);
        }

    }

    *//** Resets the array to its original configuration and return it. *//*
    public int[] reset() {

        int[] arr = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i ++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    *//** Returns a random shuffling of the array. *//*
    public int[] shuffle() {
        int[] arr = new int[list.size()];
        List<Integer> list = new ArrayList<>(this.list);
        for(int i = 0 ; i < arr.length ; i ++) {
            int removeIdx = rand.nextInt(list.size());
            arr[i] = list.get(removeIdx);
            list.remove(removeIdx);

        }
        return arr;
    }*/
    private int[] array;
    private int[] original;
    Random rand = new Random();
    private int randRange(int min , int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public DisorganizeArr(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt(2));
    }


}
