package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-25 11:55
 * @description
 * 地址：https://leetcode-cn.com/problems/merge-intervals/
 * 题目名称：合并区间
 * 描述：给出一个区间的集合，请合并所有重叠的区间。
 **/
public class MergeInterval {

    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval();
        mi.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    public int[][] merge(int[][] intervals) {

        Map<Integer,Integer> map = new HashMap<>();
        boolean flag = true;
        for(int i = 0 ; i < intervals.length ; i ++) {
            List<Integer> list = new ArrayList<>();
            list.add(intervals[i][0]);
            list.add(intervals[i][1]);
            List<Integer> removeList = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if(contents(entry.getKey() , entry.getValue() , intervals[i][0] , intervals[i][1])) {
                    list.add(entry.getKey());
                    list.add(entry.getValue());
                    removeList.add(entry.getKey());
                }
            }
            for(int num : removeList) {
                map.remove(num);
            }
            map.put(this.getMin(list),this.getMax(list));


        }
        int result[][] = new int[map.size()][2];
        int i = 0 ;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            result[i][0] = entry.getKey();
            result[i ++][1] = entry.getValue();
        }
        return result;
    }

    private int getMax(List<Integer> list) {
        int max = list.get(0);
        for(int num : list) {
            if(max < num) {
                max = num;
            }
        }
        return max;
    }

    private int getMin(List<Integer> list) {
        int min = list.get(0);
        for(int num : list) {
            if(min > num) {
                min = num;
            }
        }
        return min;
    }

    private boolean contents(int key, int value, int i, int i1) {

        if( (key >= i && key <= i1) ||(i >= key && i <= value)) {
            return true;
        }
        return false;

    }

}
