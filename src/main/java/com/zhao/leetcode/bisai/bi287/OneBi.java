package com.zhao.leetcode.bisai.bi287;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-03 10:51
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-287/problems/find-players-with-zero-or-one-losses/
 * 题目：找出输掉零场或一场比赛的玩家
 * 描述：给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 *
 * 返回一个长度为 2 的列表 answer ：
 *
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 *
 * 注意：
 *
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 *
 **/
public class OneBi {

    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> shu = new HashMap<>();

        for (int i = 0; i < matches.length; i ++) {
            int winNum = win.getOrDefault(matches[i][0], 0);
            win.put(matches[i][0], winNum + 1);
            int shuNum = shu.getOrDefault(matches[i][1], 0);
            shu.put(matches[i][1], shuNum + 1);
        }

        Set<Integer> yinList = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entry : win.entrySet()) {
            Integer num = shu.getOrDefault(entry.getKey(), null);
            if (num == null) {
                yinList.add(entry.getKey());
            }
        }
        Set<Integer> shuList = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entry : shu.entrySet()) {
            if (entry.getValue() == 1) {
                shuList.add(entry.getKey());
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(yinList));
        result.add(new ArrayList<>(shuList));
        return result;



    }

}
