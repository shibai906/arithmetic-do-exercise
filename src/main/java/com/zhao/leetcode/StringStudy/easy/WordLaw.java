package com.zhao.leetcode.StringStudy.easy;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-16 22:10
 * @description
 * 地址：https://leetcode-cn.com/problems/word-pattern/submissions/
 * 题目：单词规律
 * 描述：给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *      这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 **/
// TODO: 2020/8/16 待研究
public class WordLaw {


    public static void main(String[] args) {
        WordLaw wl = new WordLaw();
        System.out.println(wl.wordPattern("abba" , "dog cat cat dog"));
    }


    public boolean wordPattern(String pattern, String str) {


        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) return false;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            // 判断相等树的位置一样不，如果位置一样，则说明可以，如果位置不一样，就说明不满足
            if(pattern.indexOf(pattern.charAt(i)) != indexOf(arr, arr[i])){
                return false;
            }
        }
        return true;
    };

    public static int indexOf(String[] arrays, String searchString) {
        int ans = -1;
        for(int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(searchString)) {
                ans = i;
                break;
            };
        };
        return ans;
    }
//    自己的方式是错误的
//    public boolean wordPattern(String pattern, String str) {
//        Map<String,Character> map = new HashMap<>();
//        Map<String,Character> opeMap = new HashMap<>();
//        String[] strings = str.split(" ");
//        for(int i = 0 ; i < pattern.length() ; i ++) {
//            Character value = map.getOrDefault(strings[i] , null);
//            if(value == null) {
//                map.put(strings[i] , pattern.charAt(i));
//                opeMap.put(strings[i] , pattern.charAt(i));
//            } else {
//                if(!value.equals(pattern.charAt(i))) {
//                    return false;
//                } else {
//                    opeMap.remove(strings[i]);
//                }
//            }
//        }
//        if(opeMap.size() > 0) {
//            return false;
//        }
//        return true;
//    }






}
