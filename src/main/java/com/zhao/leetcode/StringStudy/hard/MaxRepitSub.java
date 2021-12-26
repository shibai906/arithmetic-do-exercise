package com.zhao.leetcode.StringStudy.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-08-15 14:10
 * @description
 **/
public class MaxRepitSub {

    public static void main(String[] args) {
        MaxRepitSub sub = new MaxRepitSub();
        System.out.println(sub.longestDupSubstring("banana"));
    }

    /*
    Rabin-Karp with polynomial rolling hash.
        Search a substring of given length
        that occurs at least 2 times.
        Return start position if the substring exits and -1 otherwise.
        */
    public int search(int L, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet();
        seen.add(h);
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = (int)S.charAt(i) - (int)'a';
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) left = L + 1;
            else right = L;
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

/*

    public String longestDupSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Set<String> set = new HashSet<>();
        String str = "";
        for (int i = s.length() - 1; i > 0; i--) {
            set.clear();
            for (int j = 0; j <= s.length() - i; j++) {
                int size = set.size();
                str = s.substring(j, j + i);
                set.add(str);
                if (size == set.size()) {
                    return str;
                }
            }
        }
        return "";

    }
*/

}
