package com.zhao.leetcode.StringStudy;

/**
 *  地址： https://leetcode-cn.com/problems/rotate-string/
 *   旋转字符串
 *      给定两个字符串, A 和 B。
 *      A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 */
public class RotateString {

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeab"));
    }

    public static boolean rotateString(String A, String B) {

        if(A == null && B == null) {
            return true;
        }
        int len = A.length();
        if(len != B.length()) {
            return false;
        }
        if(len == 0) {
            return true;
        }
        for(int i = 0 ; i < len ; i ++) {
            if(B.endsWith(A.substring(0,i + 1))) {
                if(B.startsWith(A.substring(i + 1))) {
                    return true;
                }
            }
        }
        return false;

    }

}
