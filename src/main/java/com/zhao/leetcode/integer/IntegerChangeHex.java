package com.zhao.leetcode.integer;

/**
 *  地址： https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 *  数字转换为十六进制数
 *      给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *      注意:
 *      十六进制中所有字母(a-f)都必须是小写。
 *      十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 *      给定的数确保在32位有符号整数范围内。
 *      不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 *
 */
public class IntegerChangeHex {

    public static void main(String[] args) {

        System.out.println("7.4.2".compareTo("7.4.10"));
        System.out.println(Integer.toHexString(2));
        System.out.println(0Xffffffff);
        System.out.println(toHex(2));
        System.out.println(2>>1);
    }

    public static String toHex(int num) {

        char[] record = {'a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        if(num == 0) {
            sb.append(0);
        }
        while (num != 0) {
            int n = num % 16;
            if(n > 9) {
                sb.append(record[n - 10]);
            } else {
                sb.append(n);
            }
            num <<= 4;
        }
        return sb.reverse().toString();


    }

}
