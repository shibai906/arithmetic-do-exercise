package com.zhao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-24 20:39
 * @description
 **/
public class Test58 {



    public static void main(String[] args) {
        Test58 test58 = new Test58();
        test58.totalStrength(new int[]{1,3,1,2});
    }

    public int totalStrength(int[] strength) {
        int n = strength.length, sum = strength[0];
        long[] dp = new long[n];
        dp[0] = sum * sum;
        int[] min = new int[n];
        min[0] = strength[0];
        for (int i = 1; i < n; i ++) {
            getMin(strength, i, min);
            sum += strength[i];
            dp[i] = (sum(sum, i, strength, min) + dp[i - 1]) % 1000000007;
        }
        return (int) dp[n - 1];
    }

    private long sum(int sum, int end, int[] strength, int[] min) {
        long result = sum * min[0];
        for (int i = 1; i <= end; i ++) {
            sum -= strength[i - 1];
            result += sum * min[i];
            result %=  1000000007;
        }
        return result;
    }


    private void getMin(int[] strength,int end,int[] min) {
        min[end] = strength[end];
        for (int i = end - 1; i >= 0; i --) {
            if (min[i] <= min[end]) {
                return ;
            }
            min[i] = min[end];
        }
    }

}
