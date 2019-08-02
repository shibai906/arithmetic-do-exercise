package com.zhao.leetcode.arr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 有效的字母异位词
 *  给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词
 */
public class ContantString {

    public static void main(String[] args) {

        System.out.println(ArrIsAnagram("a","b"));

    }

    public static boolean ArrIsAnagram(String s, String t) {
        int[] arr = new int[26];
        if(t.length() != s.length()) {
            return false;
        }
        for(char c : s.toCharArray()) {
            arr[c - 'a'] ++;
        }
        for(char c : t.toCharArray()) {
            arr[c - 'a'] --;
        }
        for(int i : arr) {
            if(i != 0) return false;
        }
        return true;

    }

    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> shashMap = new TreeMap<>();
        Map<Character,Integer> thashMap = new TreeMap<>();
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null || t.length() != s.length()) {
            return false;
        }
        for(int i = 0 ; i < t.length() ; i ++) {
            Integer intS = shashMap.get(s.charAt(i));
            if(intS == null) {
                shashMap.put(s.charAt(i),1);
            } else {
                shashMap.put(s.charAt(i),intS + 1);
            }
            Integer intT = thashMap.get(t.charAt(i));
            if(intT == null) {
                thashMap.put(t.charAt(i),1);
            } else {
                thashMap.put(t.charAt(i),intT + 1);
            }
        }

        Iterator sIte = shashMap.entrySet().iterator();
        Iterator tIte = thashMap.entrySet().iterator();
        while (sIte.hasNext() && tIte.hasNext()) {
            Map.Entry<String,Integer> sEntry = (Map.Entry<String, Integer>) sIte.next();
            Map.Entry<String,Integer> tEntry = (Map.Entry<String, Integer>) tIte.next();
            if(sEntry.getKey() != tEntry.getKey() || sEntry.getValue() != tEntry.getValue()) {
                return false;
            }

        }
        return true;

    }

}
