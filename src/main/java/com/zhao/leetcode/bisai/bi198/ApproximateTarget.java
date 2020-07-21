package com.zhao.leetcode.bisai.bi198;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-19 10:49
 * @description
 * 题目： 找到最接近目标值的函数值
 * 地址：https://leetcode-cn.com/contest/weekly-contest-198/problems/find-a-value-of-a-mysterious-function-closest-to-target/
 * 描述：太过于复杂，请到地址这查看
 **/
public class ApproximateTarget {

    public static void main(String[] args) {
        System.out.println(9&12);
        System.out.println(Math.abs( 9 - 10));
        System.out.println(9 & 3);
        ApproximateTarget at = new ApproximateTarget();
        System.out.println(at.closestToTarget(new int[]{9,12,3,7,15}, 5));
    }

    /**
     * 动态规划版本
     * @param arr
     * @param target
     * @return
     */
    public int closestToTarget(int[] arr, int target) {
        int n=arr.length;
        int[] dp=new int[n];
        dp[0]=arr[0];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i]==target) return 0;
            if(arr[i]<target) dp[i]=arr[i];
            if(arr[i]>target) {
                if(arr[i-1]<target) dp[i]=arr[i];
                else dp[i]=dp[i-1]&arr[i];
            }
            min=Math.min(min, Math.abs(target-dp[i]));
        }
        return min;
    }


//    public int closestToTarget(int[] arr, int target) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i : arr) {
//            if (list.isEmpty() || i != list.get(list.size() - 1)) {
//                list.add(i);
//            }
//        }
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < list.size(); i++) {
//            int X = list.get(i);
//            for (int j = i; j < list.size(); j++) {
//                X &= list.get(j);
//                ans = Math.min(ans, Math.abs(target - X));
//                if (X <= target)
//                    break;
//            }
//        }
//        return ans;
//    }


//    public int closestToTarget(int[] arr, int target) {
//        int result = Integer.MAX_VALUE ;
//        if(arr == null) {
//            return -1;
//        }
//        int bing = 0;
//        for(int i = 0 ; i < arr.length  ; i ++) {
//            for(int j = i ; j < arr.length ; j ++) {
//                if(i == j) {
//                    bing = arr[i];
//                } else {
//                    bing = bing & arr[j];
//                }
//                int abs = Math.abs(bing - target);
//                if(abs < result) {
//                    result = abs;
//                }
//            }
//        }
//
//        return result ;
//
//    }

}
