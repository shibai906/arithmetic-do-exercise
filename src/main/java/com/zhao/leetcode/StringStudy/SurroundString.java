package com.zhao.leetcode.StringStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * 环绕字符串中唯一的字符串
 */
public class SurroundString {

    public static void main(String[] args) {
        System.out.println('z' - 'a');
        System.out.println(findSubstringInWraproundString("zab"));
    }

    public static int findSubstringInWraproundString(String p) {
        if(p == null) {
            return 0;
        }
        if(p.length() < 2) {
            return p.length();
        }
        int count = 0;
        int arr[] = new int[26];
        char[] chars = p.toCharArray();
        int num = 1;
        arr[chars[0] - 'a'] ++ ;
        for(int i = 1 ; i < p.length() ; i ++) {
            if(chars[i] - chars[i - 1] == 1 || chars[i] - chars[i-1] == -25) {
                num ++ ;
            } else {
                num = 1;
            }
            arr[chars[i] - 'a'] = Math.max(arr[chars[i] - 'a'],num);
        }

        for(int sort : arr) {
            count+=sort;
        }
        return count;

    }

}
