package com.zhao.leetcode.StringStudy;

/**
 * https://leetcode-cn.com/problems/shortest-word-distance/
 * 最短单词距离
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 * easy
 */
public class MinWordJuli {

    public static void main(String[] args) {
        System.out.println(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},"coding","practice"));
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int w1 = -1 , w2 = -1;
        for(int i = 0 ; i < words.length ; i ++) {
            if(word1.equals(words[i])) {
                w1 = i;
            }
            if(word2.equals(words[i])) {
                w2 = i;
            }
            if(w1 != -1 && w2 != -1) {
                if(min > Math.abs(w1 - w2)) {
                    min = Math.abs(w1 - w2);
                }
            }
        }
        return min;
    }

}
