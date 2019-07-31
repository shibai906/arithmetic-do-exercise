package com.zhao.leetcode.StringStudy;

public class StringAdd {

    public static void main(String[] args) {

        System.out.println(addStringsGai("6","501"));

    }

    public static String addStringsGai(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int num = 0 ;
        int i = num1.length() - 1 , j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i --) ;
            int n2 = num2.charAt(j --);
            int add = n1 + n2 + num - 48;
            if(add > 48 + 9) {
                num = 1;
                sb.append((char) (add - 10));
            } else {
                sb.append((char) add);
                num = 0;
            }
        }
        while (i >= 0 ) {
            int n1 = num1.charAt(i --) ;
            int add = n1 + num ;
            if(add > 48 + 9) {
                num = 1;
                sb.append((char) (add - 10));
            } else {
                sb.append((char) add);
                num = 0;
            }
        }
        while (j >= 0 ) {
            int n1 = num2.charAt(j --) ;
            int add = n1 + num ;
            if(add > 48 + 9) {
                num = 1;
                sb.append((char) (add - 10));
            } else {
                sb.append((char) add);
                num = 0;
            }
        }
        if(num > 0) {
            sb.append(num);
        }

        return sb.reverse().toString();
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int num = 0 ;
        int i = num1.length() - 1 , j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int n1 = 48 , n2 = 48;
            if(i >= 0) {
                n1 = num1.charAt(i --) ;
            }
            if(j >= 0) {
                n2 = num2.charAt(j --);
            }
            int add = n1 + n2 + num - 48;
            if(add > 48 + 9) {
                num = 1;
                sb.append((char) (add - 10));
            } else {
                sb.append((char) add);
                num = 0;
            }

        }
        if(num > 0) {
            sb.append(num);
        }

        return sb.reverse().toString();
    }

}
