package com.zhao.leetcode.StringStudy;

import java.util.*;

/**
 * 串联所有单词的子串
 *  给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 */
public class InseriesSubString {

    public static void main(String[] args) {
        System.out.println("barfoothefoobarman".startsWith("bar"));
        System.out.println(slideFindSubString("barfoothefoobarman",new String[]{"foo","bar"}));
    }

    // 此办法属于暴力法，超时，这种方法简单的从左往右，然后依次匹配
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words == null || words.length < 1) {
            return result;
        }
        List<String> list = new ArrayList<>();
        int wordLen = 0 ;
        for(String str : words) {
            wordLen += str.length();
            list.add(str);
        }

        for(int i = 0 ; i < s.length() - wordLen + 1 ; i ++) {
            int num = 0 ;
            String caijian = s.substring(i);
            int arr[] = new int[list.size()];
            while (num < list.size()) {
                boolean flag = true;
                for(int j = 0 ; j < list.size() ; j ++) {
                    if(arr[j] == 0 && caijian.startsWith(list.get(j))) {
                        arr[j] = 1;
                        num ++ ;
                        caijian = caijian.substring(list.get(j).length());
                        flag = false;
                    }
                }
                if(flag) {
                    break;
                }
            }
            if(num == list.size()) {
                result.add(i);
            }
        }
        return result;
    }

    // 思路，使用hashMap，取一段，判断是否符合条件。
    public static List<Integer> slideFindSubString(String s , String[] words) {
        List<Integer> list = new ArrayList<>();
        if(words == null || words.length < 1) {
            return list;
        }
        Map<String,Integer> hashMap = new HashMap<>();
        for(String str : words) {
            int value = hashMap.getOrDefault(str,0) ;
            hashMap.put(str,value + 1);
        }
        int wordLen = words[0].length() , wordNum = words.length;
        char[] chars = s.toCharArray();

        for(int z = 0 ; z < wordLen ; z ++) {
            for(int i = z ; i < s.length() - wordLen * wordNum + 1; i += wordLen) {
                Map<String,Integer> hasWords = new HashMap<>();
                int num = 0;
                while (num < wordNum) {
                    String weizhi = new String(chars,i + num * wordLen, wordLen);
                    if(hashMap.containsKey(weizhi)) {
                        int value = hasWords.getOrDefault(weizhi,0);
                        if(value == hashMap.get(weizhi)) {
                            break;
                        }
                        hasWords.put(weizhi,value + 1);
                        num ++ ;
                    } else {
                        break;
                    }
                }
                if(num == wordNum) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    // 使用剪枝算法，先给排序，然后在进行计算，此算法也超时
    public static List<Integer> pruningFindSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(words == null || words.length < 1) {
            return list;
        }
        Arrays.sort(words);
        List<String> res = new ArrayList<>();
        int[] arr = new int[words.length];
        pruning(res,words,arr,0,"");
        for(int i = 0 ; i < s.length() - res.get(0).length() + 1  ; i ++) {
            for(int j = 0 ; j < res.size() ; j ++) {
                if(s.substring(i).startsWith(res.get(j))) {
                    list.add(i);
                }
            }
        }
        return list;

    }

    private static void pruning(List<String> res, String[] words, int[] arr, int start,String s) {

        if(start == arr.length - 1) {
            for(int i = 0 ; i < arr.length ; i ++) {
                if(arr[i] == 0 ) {
                    s = s + words[i];
                    res.add(s);
                    return;
                }
            }
        }
        String jilu = "";
        for(int i = 0 ; i < arr.length ; i ++) {
            if(arr[i] == 0 && !words[i].equals(jilu)) {
                arr[i] = 1 ;
                pruning(res,words,arr,start + 1,s + words[i]);
                arr[i] = 0 ;
                jilu = words[i];
            }
        }
    }

}
