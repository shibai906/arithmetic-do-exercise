package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 链接： https://leetcode-cn.com/problems/group-anagrams/
 * 题目： 字母异位词分组
 * 描述： 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * @author 赵欢
 * @time 2019-10-8 17:52
 */
public class StringGroup {

    static int[] arr = {1,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new ArrayList<>();
        boolean flag = true;
        for (String str : strs) {
            for (List<String> list : lists) {
                if(isSame(list.get(0),str)) {
                    list.add(str);
                    flag = false;
                    break;
                }
            }
            if(flag) {
                List<String> list = new ArrayList<>();
                list.add(str);
                lists.add(list);
            }
            flag = true;
        }
        return lists;
    }

    public static boolean isSame(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int i1 = 1;
        int i2 = 1;
        for (int i = 0; i < s1.length(); i++) {
            i1 *=  arr[s1.charAt(i) - 'a'];
            i2 *=  arr[s2.charAt(i) - 'a'];
        }
        if (i1 == i2) {
            return true;
        }
        return false;
    }

}
