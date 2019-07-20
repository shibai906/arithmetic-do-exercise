package com.zhao.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数字转罗马数字
 */
public class IntegerChangeRomanNum {

    public static void main(String[] args) {
        System.out.println((double) ((int) (((double) 3.8 / 5) * 10)) / 10);
        System.out.println((double) ((int)((double)3.8 / 5) * 10) / 10);
        System.out.println(intToRoman(88));
    }

    public static String intToRoman(int num) {
        Map<Integer,String> mapNumToRoman = new LinkedHashMap<>();
        mapNumToRoman.put(1000,"M");
        mapNumToRoman.put(500,"D");
        mapNumToRoman.put(100,"C");
        mapNumToRoman.put(50,"L");
        mapNumToRoman.put(10,"X");
        mapNumToRoman.put(5,"V");
        mapNumToRoman.put(1,"I");

        Map<String,String> specialMap = new HashMap<>();
        specialMap.put("D","CM");
        specialMap.put("C","CD");
        specialMap.put("L","XC");
        specialMap.put("X","XL");
        specialMap.put("V","IX");
        specialMap.put("I","IV");

        StringBuilder sb = new StringBuilder();
        int time= 1 ;
        for(Map.Entry<Integer,String> entry : mapNumToRoman.entrySet()) {
            int times = num / entry.getKey();
            num = num % entry.getKey();
            double dou = (double) ((int) (((double) num / entry.getKey()) * 10)) / 10;
            if(times == 4) {
                sb.append(specialMap.get(entry.getValue()));
            } else if( time % 2 == 0 && times == 1 && dou >= 0.8) {
                sb.append(specialMap.get(entry.getValue()));
                num = (int) (num - entry.getKey()*0.8);
            } else {
                for(int i = 0 ; i < times ; i ++) {
                    sb.append(entry.getValue());
                }
            }
            time ++ ;
         }
        return sb.toString();
    }

}
