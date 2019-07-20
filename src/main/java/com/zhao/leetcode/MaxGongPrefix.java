package com.zhao.leetcode;

/**
 * 最长公共前缀
 */
public class MaxGongPrefix {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));

    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < strs[0].length() ; i ++) {
            for(int j = 1 ; j < strs.length ; j ++) {
                if(strs[j].length() <= i) {
                    return sb.toString();
                }
                if(strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

}
