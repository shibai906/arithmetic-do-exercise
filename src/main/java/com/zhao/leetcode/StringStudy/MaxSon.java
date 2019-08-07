package com.zhao.leetcode.StringStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 无重复最长子串
 */
public class MaxSon {
    public static void main(String[] args) {
        System.out.println(myLengthOfLongestSubstring("abba",0));

    }

    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int max = 0;
        List<Character> list = new ArrayList<>();
        for(int i = 0 ; i < chars.length ; i ++) {
            for(int j = 0 ; j < list.size() ; j ++ ) {
                if(list.get(j) == chars[i]) {
                    i = i + j - list.size() + 1;
                    if(max < list.size()) {
                        max = list.size();
                    }
                    list.clear();
                }
            }

            list.add(chars[i]);
        }
        if(list.size() > max) {
            max = list.size();
        }
        return max;
    }


    // 优化滑动窗口
    public static int tarenLengthOfLongestSubstring(String s ) {
        int len = s.length() ;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>(); // 新建map集合

        for(int j = 0 , i = 0 ; j < len; j ++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i); // 当什么什么来着
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j),j + 1);
        }
        return ans;
    }

    // 我的优化滑动窗口
    public static int myLengthOfLongestSubstring(String s ,int n) {
        int len = s.length();
        int[] arr = new int[127];
        char[] chars = s.toCharArray();
        int max = 0 ;
        for(int i = 0 , j = 0 ; i < len ; i ++) {
            int num = arr[chars[i]] ;
            if(num != 0) {
                j = Math.max(j,num);
            }
            arr[chars[i]] = i + 1;
            max = Math.max(max,i - j + 1);
        }
        if(max == 0 ) {
            max = s.length();
        }
        return max;

    }


}
