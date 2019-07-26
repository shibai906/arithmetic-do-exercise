package com.zhao.leetcode.arr;

/**
 * 简单题目，名称为：加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class AddOne {

    public static void main(String[] args) {
        plusOne(new int[]{9,9});
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int plusOne = 0 ;
        int num = digits[len - 1] + 1;
        plusOne = num / 10;
        digits[len - 1] = num % 10;
        for(int i = len - 2 ; i >= 0 ; i -- ) {
            if(plusOne == 0) {
                return digits;
            } else {
                num = digits[i] + plusOne;
                digits[i] = num % 10 ;
                plusOne = num / 10;
            }
        }
        if(plusOne == 1) {
            int arr[] = new int[len + 1];
            arr[0] = plusOne;
            return arr;
        }
        return digits;
    }

}
