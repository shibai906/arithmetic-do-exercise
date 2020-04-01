package com.zhao.leetcode.StringStudy.medium;

/**
 * @program: arithmetic-do-exercise
 * @description
 *  地址： https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *  解题思路： 滑动窗口
 *  题目： 无重复字符的最长子串
 * @author: zhaohuan
 * @create: 2020-03-30 12:54
 **/
public class NoRepetitionMaxSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("a"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int arr[] = new int[128];
        char[] chars = s.toCharArray();
        int min = 0 , max = 0;
        for(int i = 0 ; i < chars.length ; i ++) {
            if(arr[chars[i]] == 0 ) {
                arr[chars[i]] = i + 1;
            } else {
                max = max > i - min ? max : i - min;
                min = min > arr[chars[i]] ? min : arr[chars[i]] ;
                arr[chars[i]] = i + 1;
            }
        }
        return max > chars.length  - min ? max : chars.length  - min;

    }


}
