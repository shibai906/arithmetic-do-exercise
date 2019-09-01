package com.zhao.leetcode.bisai.bi151;

public class MinLetter {

    public static void main(String[] args) {

    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int num = 0;
        char ch = 'z';
        if(queries.length == 1 && words.length == 1) {
            for(int i = 0 ; i < queries[0].length() ; i ++) {
                if(ch == queries[0].charAt(i)) {
                    num ++ ;
                }
                if(ch > queries[0].charAt(i)) {
                    num = 1;
                    ch = queries[0].charAt(i);
                }
            }
        }
        return null;
    }

}
