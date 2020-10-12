package com.zhao.leetcode.bisai.bi210;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-10-11 10:40
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-210/problems/maximum-nesting-depth-of-the-parentheses/
 * 题目：5535. 括号的最大嵌套深度
 * 描述：如果字符串满足一下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 *
 * 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
 * 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
 * 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
 * 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
 *
 * depth("") = 0
 * depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
 * depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
 * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 *
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 **/
public class ParenthesesMaxDepth {

    public int maxDepth(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0 , leftParentheses = 0;
        for(int i = 0 ; i < s.length() ; i ++) {
            if(s.charAt(i) == '(') {
                leftParentheses ++;
                max = Math.max(max,leftParentheses);
            }
            if(s.charAt(i) == ')') {
                leftParentheses --;
            }

        }
        return max;
    }


}
