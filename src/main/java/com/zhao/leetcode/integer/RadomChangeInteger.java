package com.zhao.leetcode.integer;

import java.util.LinkedHashMap;
import java.util.Map;

public class RadomChangeInteger {

    public static void main(String[] args) {
        int num = 2;
        num += 2;
        System.out.println(num);
        num =+ 2;
        System.out.println(num);


        System.out.println("zhao".contains("z"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
        int result = 0 ;

        // 自己想法及其做法
        /*for(Map.Entry<String,Integer> entry : map.entrySet()) {
            while ( (s.length() > 0 && s.substring(0,1).equals(entry.getKey())) || (s.length() >= 2 && s.substring(0,2).equals(entry.getKey()))){
                result = result + entry.getValue();
                s = s.substring(entry.getKey().length());
            }
        }*/
        for(int i = 0 ; i < s.length() ;) {
            if(i + 1 < s.length() && map.get(s.substring(i,i+2)) != null ) {
                result = result + map.get(s.substring(i,i+2));
                i +=  2;
            } else {
                result = result + map.get(s.substring(i,i+1));
                i ++ ;
            }
        }

        return result;

    }

}
