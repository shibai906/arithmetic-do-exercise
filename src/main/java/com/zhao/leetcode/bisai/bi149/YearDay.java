package com.zhao.leetcode.bisai.bi149;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class YearDay {

    public static void main(String[] args) {
        System.out.println(ordinalOfDate("1969-09-28"));
    }

    public static int ordinalOfDate(String date) {

        String[] strings = date.split("-");

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,31);
        map.put(3,31);
        map.put(4,31);
        map.put(5,31);
        map.put(7,31);
        map.put(8,31);
        map.put(10,31);
        map.put(4,30);
        map.put(6,30);
        map.put(9,30);
        map.put(11,30);
        int year = Integer.parseInt(strings[0]);
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) {
                    map.put(2,29);
                } else {
                    map.put(2,28);
                }
            } else {
                map.put(2,29);
            }
        } else {
            map.put(2,28);
        }
        int day = 0;
        for(int i = 1 ; i < Integer.parseInt(strings[1]); i ++) {
            day += map.get(i);
        }
        return day + Integer.parseInt(strings[2]);

    }

}
