package com.zhao.leetcode;

/**
 * 最长回文子串
 */
public class MaxHuiwenZichuan {

    public static void main(String[] args) {

        System.out.println(myDynamicProgrammingAlgorithm("accf"));

    }

    public static String longestPalindrome(String s) {

        if (s == null || s.equals("")) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                return s.substring(0, 1);
            }
            for (int j = 0; j <= i; j++) {
                String str = s.substring(j, s.length() - i + j);
                int z = 0, y = str.length() - 1;
                while (z < y) {
                    if (str.charAt(z) == str.charAt(y)) {
                        z++;
                        y--;
                    } else {
                        break;
                    }
                }
                if(z >= y) {
                    return str;
                }
            }
        }
        return null;
    }
 /*   public static boolean huiwen(String s) {


    }*/

   /* public static String manacher(String s) {

        StringBuilder sb = new StringBuilder("#");
        for(int i = 0 ; i < s.length() ; i ++) {
            sb.append(s.charAt(i)).append("#");
        }
        String manS = sb.toString();
        int[] arr = new int[manS.length()];

        for(int i = 0 ; i < manS.length() ; i ++) {
            int j = 1 ;
            while (i - j >= 0 && i + j < manS.length() && manS.charAt(i - j) == manS.charAt(i + j) ) {
                j ++ ;
            }
            arr[i] = j ;
        }
        int max = 0 ;
        int index = 0 ;
        for(int i = 0 ; i < arr.length ; i ++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i ;
            }
        }
        max = max - 1;
        index = index  / 2 ;
        if(max % 2 == 1) {
            int start = index - max / 2 ;
            int end = index + max / 2 + 1;
            return s.substring(start,end);
        } else {
            int start = index - max / 2;
            int end = index + max / 2 ;
            return s.substring(start,end);
        }
    }
*/
    public static int myDynamicProgrammingAlgorithm(String s) {

        int len = s.length();
        if(len < 2) {
            return s.length();
        }
        boolean[][] qb = new boolean[len][len];
        int maxLength = 1 ;
        int result = 0;
        for(int right = 1 ; right < len ; right ++) {
            for(int left = 0 ; left < right ; left ++) {
                if(s.charAt(right) == s.charAt(left) && (right - left <= 2 || qb[left + 1][right - 1])) {
                    qb[left][right] = true;
                    result ++ ;
                }
            }
        }
        return result + s.length();

    }







































    public static String dynamicProgrammingAlgorithm(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   l   r
        // 如果 dp[l, r] = true 那么 dp[l + 1, r - 1] 也一定为 true
        // 关键在这里：[l + 1, r - 1] 一定至少有 2 个元素才有判断的必要
        // 因为如果 [l + 1, r - 1] 只有一个元素，不用判断，一定是回文串
        // 如果 [l + 1, r - 1] 表示的区间为空，不用判断，也一定是回文串
        // [l + 1, r - 1] 一定至少有 2 个元素 等价于 l + 1 < r - 1，即 r - l >  2

        // 写代码的时候这样写：如果 [l + 1, r - 1]  的元素小于等于 1 个，即 r - l <=  2 ，就不用做判断了

        // 因为只有 1 个字符的情况在最开始做了判断
        // 左边界一定要比右边界小，因此右边界从 1 开始
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // 区间应该慢慢放大
                // 状态转移方程：如果头尾字符相等并且中间也是回文
                // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                // 否则要继续看收缩以后的区间的回文性
                // 重点理解 or 的短路性质在这里的作用
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

}
