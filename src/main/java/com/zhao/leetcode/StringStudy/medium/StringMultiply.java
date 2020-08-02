package com.zhao.leetcode.StringStudy.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-01 23:58
 * @description
 * 题目：字符串相乘
 * 地址：https://leetcode-cn.com/problems/multiply-strings/
 * 描述：给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 **/
public class StringMultiply {

    public static void main(String[] args) {
        StringMultiply sm = new StringMultiply();
        System.out.println(sm.optimizeMultiply("123","456"));
    }

    public String multiply(String num1, String num2) {

        String maxLenNum = num1.length() >= num2.length() ? num1 : num2;
        String minLenNum = num1.length() < num2.length() ? num1 : num2;
        String[] db = new String[minLenNum.length()];
        for(int i = 0 ; i < minLenNum.length() ; i ++) {
            db[i] = positionMultiply(maxLenNum , minLenNum.charAt(i) , minLenNum.length() - i - 1);
            if(i > 0) {
                db[i] = addString(db[i] , db[i - 1]) ;
            }
        }
        return db[db.length - 1];

    }

    private String addString(String s, String s1) {

        if(s.equals("0")) {
            return s1 ;
        }
        if(s1.equals("0")) {
            return s;
        }
        int tenPosition = 0 ;
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1 , i1 = s1.length() - 1 ; i >= 0 || i1 >= 0 ; i -- , i1 --) {
            int num = 0 , num1 = 0;
            if(i >= 0) {
                num = s.charAt(i) - '0';
            }
            if(i1 >= 0) {
                num1 = s1.charAt(i1) - '0';
            }
            num = tenPosition + num + num1 ;
            sb.append(num % 10) ;
            tenPosition = num / 10 ;
        }
        if(tenPosition > 0) {
            sb.append(tenPosition);
        }
        sb.reverse();
        return sb.toString();

    }

    private String positionMultiply(String maxLenNum, char minLenNum , int len) {

        if(maxLenNum.equals("0") || minLenNum == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int tenPosition = 0 ;
        for(int i = maxLenNum.length() - 1 ; i >= 0 ; i --) {
            int num = (maxLenNum.charAt(i) - '0') * (minLenNum - '0') + tenPosition ;
            sb.append(num % 10) ;
            tenPosition = num / 10 ;
        }
        if(tenPosition != 0) {
            sb.append(tenPosition);
        }
        sb.reverse();
        sb.append(this.addZero(len));
        return sb.toString();
    }

    private String addZero(int len) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < len ; i ++) {
            sb.append("0");
        }

        return sb.toString();
    }


    public String optimizeMultiply(String num1, String num2) {

        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int[] dp = new int[num1.length() + num2.length()] ;
        dp[0] = 0;

        for(int i =  num1.length() - 1 ; i >= 0 ; i --) {
            for(int j = num2.length() - 1 ; j >=0  ; j --) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + dp[i + j + 1] ;
                dp[i + j + 1] = num % 10;
                dp[i + j] += num / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        if( dp[0] != 0) {
            sb.append(dp[0]);
        }
        for(int i = 1 ; i < dp.length ; i ++) {
            sb.append(dp[i]);
        }
        return sb.toString();
    }


}
