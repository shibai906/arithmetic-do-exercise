package com.zhao.leetcode.StringStudy;

/**
 * 二进制
 *  给定两个二进制字符串，返回他们的和（用二进制表示）。
 *  输入为非空字符串且只包含数字1和0
 */
public class BinaryAdd {

    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }

    public static String elseAddBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = 0 , j = b.length() - 1,num = 0;
        while (i >= 0 || j >= 0) {
            int ai = 48 ;
            int bj = 48 ;
            if(i >= 0) {
                ai = a.charAt(i--);
            }
            if(j >= 0) {
                bj = b.charAt(j--);
            }
            int add = ai + bj + num - 48;
            if(add < 50) {
                sb.append((char)add);
                num = 0;
            }
            if(add == 50) {
                sb.append('0');
                num = 1;
            }
            if(add == 51) {
                sb.append('1');
                num = 1;
            }
        }
        if(num == 1) {
            sb.append('1');
        }
        return sb.toString();

    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1 , j = b.length() - 1,num = 0;
        while (i >= 0 || j >= 0) {
            int ai = 48 ;
            int bj = 48 ;
            if(i >= 0) {
                ai = a.charAt(i--);
            }
            if(j >= 0) {
                bj = b.charAt(j--);
            }
            int add = ai + bj + num - 48;
            if(add < 50) {
                sb.append((char)add);
                num = 0;
            }
            if(add == 50) {
                sb.append('0');
                num = 1;
            }
            if(add == 51) {
                sb.append('1');
                num = 1;
            }
        }
        if(num == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();

    }

}
