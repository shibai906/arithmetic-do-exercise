package com.zhao.leetcode.StringStudy.medium;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-09-06 17:55
 * @description
 * 地址：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
 * 题目：添加与搜索单词 - 数据结构设计
 * 描述：如果数据结构中有任何与word匹配的字符串，则bool search（word）返回true，否则返回false。 单词可能包含点“。” 点可以与任何字母匹配的地方。
 *      请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *      实现词典类 WordDictionary ：
 *          WordDictionary() 初始化词典对象
 *          void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 *          bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 **/
public class WordDictionary {

    Set<String> set = null;
    Map<Integer, Set<String>> map = null;

    /** Initialize your data structure here. */
    public WordDictionary() {
        set = new HashSet<>();
        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null) {
            return ;
        }
        set.add(word);
        Set<String> setMap = map.getOrDefault(word.length() , new HashSet<>());
        setMap.add(word);
        map.put(word.length(),setMap);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null) {
            return false;
        }
        if(word.contains(".")) {
            return this.isContain(map.get(word.length()) , word);
        } else {
            return set.contains(word);
        }
    }

    private boolean isContain(Set<String> set , String word) {
        if(set == null) {
            return false;
        }
        for(String str : set) {
            if(stringEquals(str,word)) {
                return true;
            }
        }
        return false;

    }

    private boolean stringEquals(String str, String word) {

        for(int i = 0 ; i < str.length() ; i ++) {
            if(word.charAt(i) != '.') {
                if(str.charAt(i) != word.charAt(i)) {
                    return false;
                }
            }
        }
        return true;

    }

}
