package com.zhao.leetcode.bisai.bi271;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-12-12 11:18
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-271/problems/maximum-fruits-harvested-after-at-most-k-steps/
 * 题目：在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，其中 fruits[i] = [positioni, amounti] 表示共有 amounti 个水果放置在 positioni 上。fruits 已经按 positioni 升序排列 ，每个 positioni 互不相同 。
 *
 * 另给你两个整数 startPos 和 k 。最初，你位于 startPos 。从任何位置，你可以选择 向左或者向右 走。在 x 轴上每移动 一个单位 ，就记作 一步 。你总共可以走 最多 k 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。
 *
 * 返回你可以摘到水果的 最大总数 。
 **/
public class PickFruit {

    public static void main(String[] args) {
        PickFruit pf = new PickFruit();
        System.out.println(pf.maxTotalFruits(new int[][]{{20000,10000}}, 0, 20000));
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int max = fruits[fruits.length - 1][0] + 1;
        Map<Integer, Integer> indexAndFruits = new HashMap<>();
        for (int i = 0 ; i < fruits.length ; i ++) {
            indexAndFruits.put(fruits[i][0], fruits[i][1]);
        }

        // 开始就走最左侧
        int start = 0, duo = 0, result = 0;
        if (startPos > k) {
            start = startPos - k;
        } else {
            duo = k - startPos;
        }
        for (int i = start; i <= startPos; i ++ ) {
            result += indexAndFruits.getOrDefault(i, 0);
        }
        int mobile = startPos + 1;
        if (duo >= k - startPos && k > startPos) {
            int num = duo - 2 * startPos;
            while (num > 0 && mobile < max) {
                result += indexAndFruits.getOrDefault(mobile ++, 0);
                num --;
            }
        }
        int resultMax = result;
        for (int i = start ; i < max && mobile < max; i ++) {
            if (startPos <= i) {
                return  resultMax;
            }
            if (k / (startPos - i) >= 2) {
                result -= indexAndFruits.getOrDefault(i, 0);
                result += indexAndFruits.getOrDefault(mobile ++, 0);
                result += indexAndFruits.getOrDefault(mobile ++, 0);
                resultMax = Math.max(resultMax, result);
            } else {
                if (k / (startPos - i + 1) >= 2) {
                    result += indexAndFruits.getOrDefault(mobile ++, 0);
                }
                result -= indexAndFruits.getOrDefault(i, 0);
                resultMax = Math.max(resultMax, result);
            }


        }

        return resultMax;

    }

}
