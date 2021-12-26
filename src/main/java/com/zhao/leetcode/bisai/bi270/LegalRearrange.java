package com.zhao.leetcode.bisai.bi270;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-12-05 11:07
 * @description 地址：https://leetcode-cn.com/contest/weekly-contest-270/problems/valid-arrangement-of-pairs/
 * 题目：给你一个下标从 0 开始的二维整数数组 pairs ，其中 pairs[i] = [starti, endi] 。如果 pairs 的一个重新排列，满足对每一个下标 i （ 1 <= i < pairs.length ）都有 endi-1 == starti ，那么我们就认为这个重新排列是 pairs 的一个 合法重新排列 。
 * <p>
 * 请你返回 任意一个 pairs 的合法重新排列。
 * <p>
 * 注意：数据保证至少存在一个 pairs 的合法重新排列。
 **/
public class LegalRearrange {

    public static void main(String[] args) {
        LegalRearrange lr = new LegalRearrange();
        lr.validArrangement(new int[][]{{5,1},{4,5},{11,9},{9,4}});
    }

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < pairs.length ; i ++) {
            map.put(pairs[i][0], pairs[i][1]);
        }
        int wei = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.get(entry.getValue()) == null) {
                wei = entry.getKey();
            }
        }
        return null;
    }

}

class Node {
    Node right;
    int one;
    int two;
    Node left;
}
