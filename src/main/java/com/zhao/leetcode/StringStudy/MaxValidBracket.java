package com.zhao.leetcode.StringStudy;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/submissions/
 * 最长有效括号
 *  给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *  待做，妈的，使用stack居然有很多坑
 */
public class MaxValidBracket {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")))(())"));
    }

    public static int longestValidParentheses(String s) {

        int max = 0 ;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0 ; i < s.length() ; i ++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();    // 如何有多个
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max , i - stack.peek());
                }
            }
        }
        return max;

    }

}
