package com.zhao.leetcode;

/**
 * String类型转化成integer
 */
public class StringTurnInteger {
    public static void main(String[] args) {

        System.out.println(myAtoi("20000000000000000000"));

    }

    public static int myAtoi(String str) {
        str = str.trim();
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[\\+\\-\\d]\\d*");
        java.util.regex.Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str = str.substring(matcher.start(), matcher.end());
        } else {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sb.append(str.charAt(0));
            str = str.substring(1);
        }
        pattern = java.util.regex.Pattern.compile("[1-9]\\d*");
        matcher = pattern.matcher(str);
        if (matcher.find()) {
            sb.append(str.substring(matcher.start(), matcher.end()));
        } else {
            return 0;
        }
        str = sb.toString();
        if (str.length() > 11) {
            if (str.charAt(0) == '-') {
                return -Integer.MAX_VALUE - 1;
            }
            return Integer.MAX_VALUE;
        }
        if (str.length() == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            return 0;
        }
        long ret = Long.parseLong(str);

        if (ret + 1 <= -Integer.MAX_VALUE) {
            return -Integer.MAX_VALUE - 1;
        }
        if (ret >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ret;


    }
}
