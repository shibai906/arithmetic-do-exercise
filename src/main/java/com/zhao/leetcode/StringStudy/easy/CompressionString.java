package com.zhao.leetcode.StringStudy.easy;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-26 22:25
 * @description
 * 地址：https://leetcode-cn.com/problems/string-compression/
 * 题目：压缩字符串
 *      描述：给定一组字符，使用原地算法将其压缩。
 *      压缩后的长度必须始终小于或等于原数组长度。
 *      数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *      在完成原地修改输入数组后，返回数组的新长度。
 *
 **/
public class CompressionString {

    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        }
        int num = 1 ;
        char c = chars[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < chars.length ; i ++ ) {
            if(c != chars[i]) {
                sb.append(c);
                if(num > 1) {
                    sb.append(num);
                }
                num = 1;
                c = chars[i];
            } else {
                num ++ ;
            }
        }
        sb.append(c);
        if(num > 1) {
            sb.append(num);
        }
        for(int i = 0 ; i < sb.length() ; i ++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();

    }


}
