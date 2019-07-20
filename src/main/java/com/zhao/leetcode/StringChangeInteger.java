package com.zhao.leetcode;


public class StringChangeInteger {
    public static void main(String[] args) {
        System.out.println(-Integer.MAX_VALUE - 1);
        System.out.println(myAtoi("-000000000000001"));
    }
    public static int myAtoi(String str) {
        str = str.trim();
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[\\+\\-\\d]\\d*");
        java.util.regex.Matcher m = pattern.matcher(str);
        String res = null;
        if(m.find()) {
            res = str.substring(m.start(),m.end());
        } else {
            return 0;
        }
        if(res.length() == 1 && (res.charAt(0) == '+' || res.charAt(0) == '-')) {
            return 0;
        }
        boolean flag = res.charAt(0) == '-' ? false : true;
        if(res.charAt(0) == '+' || res.charAt(0) == '-') {
            res = res.substring(1);
        }
        while (res.length() > 0 && res.charAt(0) == '0') {
            res = res.substring(1);
        }

        if(res.equals("")) {
            return 0;
        }
        if(res.length() > 10) {
            if(!flag) {
                return - Integer.MAX_VALUE - 1;
            }
            return Integer.MAX_VALUE;
        }
        long l = Long.parseLong(res);
        if(flag) {
            if(l >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) l;
        }else {
            if(l - 1 >= Integer.MAX_VALUE) {
                return - Integer.MAX_VALUE - 1;
            }
            return (int) -l;

        }


    }
}
