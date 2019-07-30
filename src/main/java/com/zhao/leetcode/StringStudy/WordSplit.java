package com.zhao.leetcode.StringStudy;

import java.util.*;

/**
 * 单词拆分
 */
public class WordSplit {


    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(1);
        queue.remove();

    }


    /**
     * 动态规划思路，是给定的字符串可以拆分成子问题s1和s2。如果这些子问题可以独立地拆分成符合要求的子问题，
     * 那么整个s可以以满足。就是看元素组成，是否存在满足子串合并子串到最后一位
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean dynamicPlanning(String s , List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1 ; i <= len ; i ++) {
            for(int j = 0 ; j < i ; j ++) {
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    /**
     *  可将字符串可视化成一棵树，每个节点是使用end为结尾的前缀字符串。当两个节点之间的所有节点都对应了
     *  字典中一个有效字符串时，两个节点可以被链接。
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean breadthPrioritySeek(String s , List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while ( ! queue.isEmpty()) {
            int start = queue.remove();
            if(visited[start] == 0) {
                for(int end = start + 1 ; end <= s.length() ; end ++) {
                    if(wordSet.contains(s.substring(start,end))) {
                        queue.add(end);         // 每次只能放入一次
                        if(end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;     // 标记已经参加过的
            }
        }
        return false;

    }



}
