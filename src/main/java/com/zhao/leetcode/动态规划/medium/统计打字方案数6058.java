package com.zhao.leetcode.动态规划.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-08 21:50
 * @description
 * 地址：https://leetcode-cn.com/problems/count-number-of-texts/
 * 题目：统计打字方案数
 * 描述：Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 *
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 *
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 *
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 *
 * 由于答案可能很大，将它对 10^9 + 7 取余 后返回。
 *
 **/
public class 统计打字方案数6058 {

    public int countTexts(String pressedKeys) {
        if (pressedKeys == null || pressedKeys.length() == 0) {
            return 0;
        }
        int n = pressedKeys.length();
        long dp[] = new long[n];
        dp[0] = 1;
        int lianxu = 1;
        for (int i = 1; i < n; i ++) {
            char c = pressedKeys.charAt(i);
            if (c == pressedKeys.charAt(i - 1)) {
                lianxu ++;
            } else {
                lianxu = 1;
            }
            jisuanDp(dp, lianxu, i, c);

        }
        return (int) (dp[n - 1] % 1000000007);
    }

    private void jisuanDp(long[] dp, int lianxu, int i, char c) {
        dp[i] = dp[i - 1];
        long nextNext = 1;
        if (lianxu >= 2) {
            if (i >= 2) {
                nextNext = dp[i - 2];
            }
            dp[i] = dp[i] + nextNext;
        }
        long nextNextNext = 1;
        if (lianxu >= 3) {
            if (i >= 3) {
                nextNextNext = dp[i - 3];
            }
            dp[i] = dp[i] + nextNextNext;
        }
        long nextNextNextNext = 1;
        if (lianxu >= 4) {
            if (i >= 4) {
                nextNextNextNext = dp[i - 4];
            }
            if (c == '7' || c == '9') {
                dp[i] = dp[i] + nextNextNextNext;
            }
        }
        dp[i] %= 1000000007;
    }

}
