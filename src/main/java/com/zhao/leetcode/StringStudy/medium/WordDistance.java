package com.zhao.leetcode.StringStudy.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-30 21:00
 * @description
 * 题目：最短单词距离 II
 * 地址：https://leetcode-cn.com/problems/shortest-word-distance-ii/
 * 描述：请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用 多次。
 * 思路：自己写的类，没有考虑元素插入时的特性，不会利用空间，造成超时，一句话，就是没看清题意，造成题做错
 *      设计题，应该学会好好设计，启动可以慢，但是运行不能特别慢
 **/
public class WordDistance {

    public static void main(String[] args) {
        WordDistance wordDistance = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        wordDistance.shortest("coding","makes");
    }

    Map<String, List<Integer>> map = null;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0 ; i < words.length ; i ++) {
            List<Integer> list = map.get(words[i]);
            if(list == null) {
                list = new ArrayList<>();
                map.put(words[i],list);
            }
            list.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        if(list1 == null || list2 == null) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        int i = 0 , j = 0;
        while (list1.size() > i && list2.size() > j) {
            int num1 = list1.get(i),num2 = list2.get(j);
            if(num1 > num2) {
                result = Math.min(result , num1 - num2);
                j ++;
            }
            if(num1 == num2) {
                return 0;
            }
            if(num1 < num2) {
                result = Math.min(result,num2 - num1);
                i ++;
            }
        }
        return result;
    }



}
