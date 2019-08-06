package com.zhao.leetcode.bisai.bi148;

/**
 * 段式回文  显示英文描述
 * 用户通过次数 83
 * 用户尝试次数 102
 * 通过次数 83
 * 提交次数 206
 * 题目难度 Hard
 * 段式回文 其实与 一般回文 类似，只不过是最小的单位是 一段字符 而不是 单个字母。
 *
 * 举个例子，对于一般回文 "abcba" 是回文，而 "volvo" 不是，但如果我们把 "volvo" 分为 "vo"、"l"、"vo" 三段，则可以认为 “(vo)(l)(vo)” 是段式回文（分为 3 段）。
 *
 * 给你一个字符串 text，在确保它满足段式回文的前提下，请你返回 段 的 最大数量 k。
 *
 * 如果段的最大数量为 k，那么存在满足以下条件的 a_1, a_2, ..., a_k：
 *
 * 每个 a_i 都是一个非空字符串；
 * 将这些字符串首位相连的结果 a_1 + a_2 + ... + a_k 和原始字符串 text 相同；
 * 对于所有1 <= i <= k，都有 a_i = a_{k+1 - i}。
 */
public class SectionPla {

    public static void main(String[] args) {
        System.out.println(longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
    }

    public static int longestDecomposition(String text) {

        int len = text.length();
        int num = 0 ;
        for(int i = 1 ; i <= len / 2 ; i ++) {
            if(text.endsWith(text.substring(0,i))) {
                text = text.substring(i,len - i);
                num += 2;
                i = 1;
                len = text.length();
            }
        }
        if(text.length() > 0) {
            num ++;
        }
        return num ;
    }

}
