package com.zhao.leetcode.StringStudy;

public class VerifyPlalind {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {

        int i = 0 , j = s.length() - 1 , count = 1;
        char[] chars = s.toCharArray();
        while ( i < j) {
            while (i < j && !((chars[i] > 64 && chars[i] < 91) ||(chars[i] > 96 && chars[i] < 123) || (chars[i] > 47 && chars[i] < 58))  ) {
                i ++ ;
            }
            while (i < j && !((chars[j] > 64 && chars[j] < 91) || (chars[j] > 96 && chars[j] < 123) || (chars[j] > 47 && chars[j] < 58))  ) {
                j -- ;
            }
            if(!(chars[i] == chars[j] || (chars[i] > 64 && chars[j] > 64 && (chars[i] == chars[j] + 32 || chars[i] == chars[j] - 32)))) {
                count -- ;
            }
            i ++ ;
            j -- ;
        }
        return count > 0;

    }

}
