package com.zhao.leetcode.StringStudy;


/**
 * 转换成小写字母
 *  实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 */
public class TransitionLetter {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0 ; i < str.length() ; i ++) {
            if(chars[i] <= 90 && chars[i] >= 65) {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);

    }

}
