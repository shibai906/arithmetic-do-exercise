package com.zhao.leetcode.bisai.bi202;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-16 11:27
 * @description
 * 题目：吃掉 N 个橘子的最少天数
 * 地址：https://leetcode-cn.com/contest/weekly-contest-202/problems/minimum-number-of-days-to-eat-n-oranges/
 * 描述：厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
 *      吃掉一个橘子。
 *      如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
 *      如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
 *      每天你只能从以上 3 种方案中选择一种方案。
 *      请你返回吃掉所有 n 个橘子的最少天数。
 **/
public class EatNorangeNum {

    public static void main(String[] args) {
        EatNorangeNum ear = new EatNorangeNum();
        System.out.println(ear.myMinDays(10));
    }

    // 使用贪心算法，吃最多，这个不行
    // 使用动态规划加贪心算法，这种如何数特别大，内存占用会特别大
//    public int minDays(int n) {
//        if(n == 0) {
//            return 0;
//        }
//        int dp[] = new int[n];
//        dp[0] = 1 ;
//        int suan = 0;
//        for(int i = 1 ; i < n ; i ++) {
//            int minTimes = Integer.MAX_VALUE;
//            int zhi = i + 1;
//            if(zhi % 3 == 0) {
//                suan = zhi - 2*(zhi/3);
//                minTimes = Math.min(minTimes , 1 + dp[suan - 1]);
//            }
//            if(zhi % 2 == 0) {
//                suan = zhi - zhi / 2 ;
//                minTimes = Math.min(minTimes , 1 + dp[suan - 1]);
//            }
//            minTimes = Math.min(minTimes , 1 + dp[i - 1]);
//            dp[i] = minTimes;
//
//        }
//        return dp[n - 1];
//    }


    // 写法流程：得了解详细流程，要是不了解详细流程，很容易入坑
    public int myMinDays(int n) {
        if(n < 0) {
            return 0;
        }
        HashSet<Integer> record = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        int res = 1 ;
        while (true) {
            ArrayList<Integer> next = new ArrayList<>();
            for(int i = list.size() - 1 ; i >= 0 ; i --) {
                int num = list.get(i);

                if(record.contains(num)) {
                    continue;
                }
                if(num == 1) {
                    return res;
                }
                if(num % 2 == 0) {
                    next.add(num / 2);
                }
                if(num % 3 == 0) {
                    next.add(num / 3);
                }
                next.add(num - 1);
            }
            res ++ ;
            list = next;
        }
    }


    // 优秀代码
    public int minDays(int n) {
        HashSet<Integer> seen = new HashSet();
        ArrayList<Integer> list = new ArrayList();
        list.add(n);
        int res = 1;
        while(true){
            ArrayList <Integer> next = new ArrayList();
            for(int i = list.size() - 1; i >= 0; i--)
            {
                int cur = list.get(i);
                if(seen.contains(cur)) continue;
                if(cur == 1)
                    return res;
                seen.add(cur);
                if(cur % 2 == 0)
                    next.add(cur / 2);
                if(cur % 3 == 0)
                    next.add(cur / 3);
                next.add(cur - 1);
            }
            list = next;
            res++;
        }
    }


}
