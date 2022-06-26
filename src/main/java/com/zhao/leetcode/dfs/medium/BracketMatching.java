package com.zhao.leetcode.dfs.medium;

import org.apache.kafka.common.protocol.types.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-06-04 16:48
 * @description
 * 地址：https://leetcode.cn/problems/IDBivT/
 * 题目：生成匹配的括号
 * 描述：正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 **/
public class BracketMatching {

    public static void main(String[] args) {
        BracketMatching bracketMatching = new BracketMatching();
        bracketMatching.generateParenthesis(3);
    }

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, "", 0, 0);
        return result;
    }

    private void dfs(int n, String str , int leftNum, int rightNum) {

        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }

        if (leftNum < n) {
            dfs(n, str + "(", leftNum + 1, rightNum);
        }
        if (rightNum < leftNum) {
            dfs(n, str + ")", leftNum, rightNum + 1);
        }


    }

}
