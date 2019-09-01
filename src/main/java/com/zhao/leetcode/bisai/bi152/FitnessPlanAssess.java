package com.zhao.leetcode.bisai.bi152;

public class FitnessPlanAssess {

    public static void main(String[] args) {
        dietPlanPerformance(new int[]{6,5,0,0} ,2,1,5);
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int minute = 0, countK = 0 , add = 0;
        for(int i = 0 ; i < calories.length ; i ++) {
            add += calories[i] ;
            countK ++ ;
            if(countK == k) {
                if(add < lower) {
                    minute -- ;
                }
                if(add > upper) {
                    minute ++;
                }
                add = 0 ;
                countK = 0 ;
                i = i - k + 1;
            }

        }
        return minute;
    }

}
