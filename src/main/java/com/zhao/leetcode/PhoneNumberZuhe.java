package com.zhao.leetcode;

import java.util.*;

/**
 * 电话号码任意数字组合
 */
public class PhoneNumberZuhe {

    static List<String> result = new ArrayList<>();
    static Map<String,String> map = new HashMap<>();
    static {
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }

    public static void main(String[] args) {
        System.out.println((Arrays.toString(letterCombinations("2310").toArray())));
    }

    public static List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        recursion(digits,sb);
        return result;

    }

    public static void recursion(String digits ,StringBuilder sb) {
        String get = null ;
        while (digits.length() > 0 && get == null ) {
            get = map.get(digits.substring(0,1));
            digits = digits.substring(1);
        }
        if(get == null) {
            if(sb.length() > 0) {
                result.add(sb.toString());
            }
            return;
        }

        if(digits.length() < 1) {
            for(int i = 0 ; i < get.length() ; i ++) {
                String str = sb.toString() + get.charAt(i);
                result.add(str);
            }
        } else {
            for(int i = 0 ; i < get.length() ; i ++) {
                sb.append(get.charAt(i));
                recursion(digits,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }

}
