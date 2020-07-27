package com.zhao.leetcode.bisai.bi199;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-26 10:37
 * @description
 **/
public class ResetString {

    public static void main(String[] args) {
        ResetString rs = new ResetString();
        rs.restoreString("codeleet",new int[]{4,5,6,7,0,2,1,3});
    }

    public String restoreString(String s, int[] indices) {

        char[] chars = new char[s.length()];
        for(int i = 0 ; i < indices.length ; i ++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);

    }

}
