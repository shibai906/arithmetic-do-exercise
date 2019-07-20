package com.zhao.leetcode;


/**
 * 实现strStr()
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
