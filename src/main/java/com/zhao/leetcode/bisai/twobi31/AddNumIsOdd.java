package com.zhao.leetcode.bisai.twobi31;

import com.zhao.multithreading.deadlock.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-25 22:48
 * @description
 * 地址：https://leetcode-cn.com/contest/biweekly-contest-31/problems/number-of-sub-arrays-with-odd-sum/
 * 题目：和为奇数的子数组数目
 * 描述：给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
 *      由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
 **/
// TODO: 2020/7/26 不懂这个题，还得感觉做 
public class AddNumIsOdd {

    private int adda = 0;
    public static void main(String[] args) {
        AddNumIsOdd ano = new AddNumIsOdd();
        System.out.println(ano.numOfSubarrays(new int[]{100,100,99,99}));
    }


    public int num(int arr[]) {
        int sum=0,ans=0;
        int[] count = new int[2];
        count[0]++;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            count[sum%2]++;
            ans+=count[sum%2==0 ? 1 : 0];
            ans%=1000000007;
        }
        return ans;
    }

    private int result = 0;
    public int numOfSubarrays(int[] arr) {
        int max = 1000000007 ;
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int  add = 0 , start = 0;
        addNum(arr,  add , start) ;
        System.out.println(adda);
        return result % max ;

    }



    private void addNum(int[] arr,  int add , int start) {
        adda ++;
        for( ;start < arr.length ; start ++ ) {
            if(start > 0 && arr[start] == arr[start-1] ) {
                break;
            }
            add += arr[start] ;
            addNum(arr ,  add , start + 1);
            if(add % 2 == 1) {
                result ++ ;
            }
            add -= arr[start];
        }

    }

}
