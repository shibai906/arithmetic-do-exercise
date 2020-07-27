package com.zhao.leetcode.bisai.twobi31;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-25 23:34
 * @description
 * 地址：https://leetcode-cn.com/contest/biweekly-contest-31/problems/number-of-good-ways-to-split-a-string/
 * 题目：字符串的好分割数目
 * 描述：给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 *      请你返回 s 中好分割的数目
 **/
public class StringSpil {

    public int numSplits(String s) {
        Set<Character> set = new HashSet<>();
        int left[] = new int[s.length()] ;
        for(int i = 0 ; i < s.length() ; i ++) {
            set.add(s.charAt(i));
            left[i] = set.size();
        }
        set.clear();
        int right[] = new int[s.length()] ;
        for(int i = s.length() - 1 ; i >= 0 ; i --) {
            set.add(s.charAt(i));
            right[i] = set.size();
        }
        int result = 0;
        for(int i = 1 ; i < s.length() ; i ++ ) {
            if(left[i - 1] == right[i]) {
                result ++ ;
            }
        }
        return result;

    }

}
