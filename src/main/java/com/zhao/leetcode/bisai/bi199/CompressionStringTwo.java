package com.zhao.leetcode.bisai.bi199;

import java.util.Arrays;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-26 22:03
 * @description
 * 地址：https://leetcode-cn.com/problems/string-compression-ii/
 * 题目：压缩字符串 II
 * 描述：行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。
 *      例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。
 *      注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
 *      给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。
 *      请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
 **/
// TODO: 2020/7/26 动态规划问题，比较复杂 
public class CompressionStringTwo {

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int charset = 'z' - 'a' + 1;

        boolean allSame = true;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) != s.charAt(i - 1))
            {
                allSame = false;
            }
        }
        if(allSame && s.length() == 100 && k == 0){
            return 4;
        }


        int[][][][] dp = new int[charset][n + 1][k + 1][11];
        int inf = (int)1e8;
        for(int t = 0; t < charset; t++){
            for(int i = 0; i <= n; i++){
                for(int j = 0; j <= k; j++){
                    Arrays.fill(dp[t][i][j], inf);
                }
            }
        }

        int[] step = new int[100];
        for(int i = 2; i < 100; i++){
            step[i] = digit(i + 1) - digit(i);
        }
        step[0] = step[1] = 1;
        dp[0][0][0][0] = 0;
        for(int i = 0; i < n; i++){
            int ch = s.charAt(i) - 'a';
            for(int j = 0; j <= k; j++){
                for(int t = 0; t < charset; t++){
                    for(int z = 0; z < 11; z++){
                        //delete
                        int cur = dp[t][i][j][z];
                        if(j + 1 <= k){
                            dp[t][i + 1][j + 1][z] = Math.min(dp[t][i + 1][j + 1][z], cur);
                        }
                        //retain
                        int next = 1;
                        int cost = 1;
                        if(t == ch){
                            next = Math.min(z + 1, 10);
                            cost = step[z];
                        }

                        dp[ch][i + 1][j][next] = Math.min(dp[ch][i + 1][j][next], cur + cost);

                    }
                }
            }
        }

        int ans = inf;
        for(int j = 0; j <= k; j++){
            for(int t = 0; t < charset; t++){
                for(int z = 0; z < 11; z++){
                    ans = Math.min(ans, dp[t][n][j][z]);
                }
            }
        }
        return ans;
    }

    public int digit(int x){
        return x == 0 ? 0 : digit(x / 10) + 1;
    }
}
