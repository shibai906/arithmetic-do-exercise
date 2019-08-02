package com.zhao.leetcode.StringStudy;


/**
 * 实现strStr()
 *  给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("hellow","a"));

    }

    public static int strStr(String haystack, String needle) {
        if(haystack == null) {
            return -1;
        }
        int lenHay = haystack.length();
        int lenNeed = needle.length();
        if(lenHay < lenNeed) {
            return -1;
        }
        char[] chars = haystack.toCharArray();
        for(int i = 0 ; i < lenHay - lenNeed + 1 ; i ++ ) {
            if(new String(chars,i,lenNeed ).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
