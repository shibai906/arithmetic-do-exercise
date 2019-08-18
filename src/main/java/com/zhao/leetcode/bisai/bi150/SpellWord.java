package com.zhao.leetcode.bisai.bi150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 拼写单词
 *  给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
public class SpellWord {

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"hello","world","leetcode"},"weldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {
        if(words == null || chars == null) {
            return 0;
        }
        List<String> list = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < chars.length(); i ++) {
            int num = map.getOrDefault(chars.charAt(i),0);
            map.put(chars.charAt(i),num+1);
        }
        for(int i = 0 ; i < words.length; i ++) {
            int j = 0;
            int arr[] = new int[26];
            for( ; j < words[i].length() ; j ++) {
                arr[words[i].charAt(j) - 'a'] ++;
                if(map.get(words[i].charAt(j)) == null || map.get(words[i].charAt(j)) < arr[words[i].charAt(j) - 'a']) {
                    break;
                }
            }
            if(j == words[i].length() ) {
                list.add(words[i]);
            }
        }
        int result = 0;
        for(String str : list) {
            result += str.length();
        }
        return result;
    }

}
