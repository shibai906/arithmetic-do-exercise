package com.zhao.leetcode.dfs.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-03 10:20
 * @description
 * 地址：https://leetcode-cn.com/problems/n-queens/
 * 题目：N 皇后
 * 描述：n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *  给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *  每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 **/
public class MoreQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        dfs(lists, list, n);
        List<List<String>> result = new ArrayList<>();
        if (lists.size() < 1) {
            return result;
        }
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0 ; i < n; i ++) {
            StringBuilder sb = new StringBuilder();
            setPoint(sb, i);
            sb.append("Q");
            setPoint(sb, n - i - 1);
            map.put(i, sb.toString());
        }
        lists.stream().forEach(l -> {
            List<String> listString = new ArrayList<>();
            l.stream().forEach(i -> {
                listString.add(map.get(i));
            });
            result.add(listString);
        });
        return result;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> list, int n) {
        if (list.size() == n) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = 0; i < n; i ++) {
            if (list.contains(i)) {
                continue;
            }
            if (isConform(list, i)) {
                list.add(i);
                dfs(lists, list, n);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isConform(List<Integer> list, int target) {
        if (list.size() == 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i ++) {
            if (Math.abs((list.get(i) - target)) == list.size() - i) {
                return false;
            }
        }
        return true;
    }

    private void setPoint(StringBuilder sb, int n) {
        for (int i = 0; i < n; i ++) {
            sb.append(".");
        }
    }

}
