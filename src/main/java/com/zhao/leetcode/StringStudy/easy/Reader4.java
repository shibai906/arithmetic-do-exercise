package com.zhao.leetcode.StringStudy.easy;

import java.util.Arrays;

/**
 * 地址：https://leetcode-cn.com/problems/read-n-characters-given-read4/
 *  题目： 用 Read4 读取 N 个字符
 *  给你一个文件，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够读取 n 个字符。
 *
 * read4 方法：
 *
 * API read4 可以从文件中读取 4 个连续的字符，并且将它们写入缓存数组 buf 中。
 *
 * 返回值为实际读取的字符个数。
 *
 * 注意 read4() 自身拥有文件指针，很类似于 C 语言中的 FILE *fp 。
 *
 * read4 的定义：
 *
 * 参数类型: char[] buf
 * 返回类型: int
 *
 * 注意: buf[] 是目标缓存区不是源缓存区，read4 的返回结果将会复制到 buf[] 当中。
 */
public class Reader4 {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] arr1 = {5,6,7,8};
        System.arraycopy(arr,0,arr1,0,4);
        System.out.println(Arrays.toString(arr1));
    }

    public int read4(char[] buf , int n) {


        /*char[] temp = new char[4];
        int index = 0;
        while (index < n) {
            read4(temp);
            index += 4;
            if(index >= n) {
                System.arraycopy(temp,0,buf,0,index + 4 - n);
            }
        }

        return index + 4 - n;*/

        /*int count = 0;
        int sum = 0;
        char[] temp = new char[4];
        int index = 0;
        while(index < n) {
            count = read4(temp);
            for(int i = 0;i < count;i++) {
                buf[index+i] = temp[i];
            }

            sum += count;
            index += 4;
        }

        return sum > n ? n : sum;*/
        return 0;
    }

}
