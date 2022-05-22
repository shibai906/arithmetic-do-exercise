package com.zhao.leetcode.bisai.bi288;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-10 10:35
 * @description
 **/
public class ExchangeNum {

    public static void main(String[] args) {
        ExchangeNum en = new ExchangeNum();
        en.largestInteger(65875);
    }

    public int largestInteger(int num) {

        String s = String.valueOf(num);

        List<Integer> list = new ArrayList<>();

        List<Integer> ji = new ArrayList<>();
        List<Integer> ou = new ArrayList<>();

        for (int i = 0; i < s.length(); i ++) {
            int n = s.charAt(i) - '0';
            int yushu = n % 2;
            list.add(yushu);
            if (yushu == 1) {
                ji.add(n);
            } else {
                ou.add(n);
            }
        }
        Collections.sort(ji);
        Collections.sort(ou);
        StringBuilder sb = new StringBuilder();

        for (int l : list) {
            if (l == 1) {
                sb.append(ji.remove(ji.size() - 1));
            } else {
                sb.append(ou.remove(ou.size() - 1));
            }
        }
        return Integer.parseInt(sb.toString());


    }

}
