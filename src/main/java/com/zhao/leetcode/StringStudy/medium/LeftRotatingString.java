package com.zhao.leetcode.StringStudy.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-13 16:19
 * @description
 * 题目：左旋转字符串
 * 描述：Input:
 *      S="abcXYZdef"
 *      K=3
 *
 *      Output:
 *      "XYZdefabc"
 * 题解：双指针旋转
 * 如： 先旋转前面的，abc -> cba  旋转后面的 XYZdef -> fedXYZ  结果为： cbafedXYZ 总体旋转 -> ZYXdefabc
 **/
public class LeftRotatingString {


    public static void main(String[] args) {
        LeftRotatingString lrs = new LeftRotatingString();
        lrs.LeftRotateString("abcXYZdef",3);
    }

    public String LeftRotateString(String str, int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

}




















































