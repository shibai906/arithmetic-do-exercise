package com.zhao.leetcode.bisai.bi202;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-16 10:56
 * @description
 * 地址：https://leetcode-cn.com/problems/magnetic-force-between-two-balls/
 * 题目：两球之间的磁力
 * 描述：在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 *      Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 *      已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 *      给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 *
 **/
public class TwoBallGravitation {

    public static void main(String[] args) {
        TwoBallGravitation tg = new TwoBallGravitation();
        System.out.println(tg.maxDistance(new int[]{1,2,3,4,5,6,7,8,9,10} , 4));
    }

    private int minMax = 0 ;
    public int maxDistance(int[] position, int m) {
        if(position == null || position.length == 0 || m == 0) {
            return 0;
        }
        Arrays.sort(position);

        if(m == 2) {
            return position[position.length - 1] - position[0];
        }
        Set<Integer> set = new TreeSet<>();
        set.add(position[0]);
        set.add(position[position.length - 1]);
        huisuo(position, 1 , set , m - 2);

        return minMax;
    }

    private void huisuo(int[] position, int start, Set<Integer> set , int m) {

        if(m == 0) {
            List<Integer> list = new ArrayList<>(set);
            int min = list.get(1) - list.get(0);
            for(int i = 2 ; i < list.size() ; i ++) {
                if((list.get(i) - list.get(i - 1)) < min) {
                    min = list.get(i) - list.get(i - 1);
                }
            }
            if(min > minMax) {
                minMax = min;
            }
            return;
        }

        for( ; start < position.length - 1 ; start ++) {
            set.add(position[start]);
            huisuo(position , start + 1 , set , m - 1);
            set.remove(position[start]);
        }

    }

//
//    int[] pos;
//    public int maxDistance(int[] position, int m) {
//        Arrays.sort(position);
//        pos = position;
//        int n = pos.length;
//        if(m == 2) return pos[n - 1] - pos[0];
//        int mid = 0, lo = 0, hi = pos[n - 1];
//        while (lo <= hi) {
//            mid = lo + (hi - lo) / 2;
//            int res = f(mid);
//            if(res >= m)
//                lo = mid + 1;
//            else
//                hi = mid - 1;
//        }
//        return hi;
//    }
//    int f(int gap){
//        int res = 1, last = pos[0];
//        for(int i : pos)
//        {
//            if(i - last >= gap)
//            {
//                res++;
//                last = i;
//            }
//        }
//        return res;
//    }


}
