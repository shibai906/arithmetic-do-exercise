package com.zhao.leetcode.StringStudy;

public class ZZixinChange {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int oneNum = numRows + (numRows - 2);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < numRows ; i ++) {
            if(i == 0 || i == numRows - 1){
                int num = i;
                while (num < s.length()) {
                    sb.append(s.charAt(num));
                    num = num + oneNum;
                }
            } else  {
                int num1 = i;
                int num2 = oneNum - i ;
                while (num1 < s.length()) {
                    sb.append(s.charAt(num1));
                    num1 = num1 + oneNum;
                    if(num2 < s.length()) {
                        sb.append(s.charAt(num2));
                        num2 = num2 + oneNum;
                    }
                }
            }

        }

        return sb.toString();
    }


}
