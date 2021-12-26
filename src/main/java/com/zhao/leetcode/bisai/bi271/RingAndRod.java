package com.zhao.leetcode.bisai.bi271;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-12-12 10:34
 * @description 地址：https://leetcode-cn.com/contest/weekly-contest-271/problems/rings-and-rods/
 * 题目：总计有 n 个环，环的颜色可以是红、绿、蓝中的一种。这些环分布穿在 10 根编号为 0 到 9 的杆上。
 * <p>
 * 给你一个长度为 2n 的字符串 rings ，表示这 n 个环在杆上的分布。rings 中每两个字符形成一个 颜色位置对 ，用于描述每个环：
 * <p>
 * 第 i 对中的 第一个 字符表示第 i 个环的 颜色（'R'、'G'、'B'）。
 * 第 i 对中的 第二个 字符表示第 i 个环的 位置，也就是位于哪根杆上（'0' 到 '9'）。
 * 例如，"R3G2B1" 表示：共有 n == 3 个环，红色的环在编号为 3 的杆上，绿色的环在编号为 2 的杆上，蓝色的环在编号为 1 的杆上。
 * <p>
 * 找出所有集齐 全部三种颜色 环的杆，并返回这种杆的数量。
 **/
public class RingAndRod {

    public static void main(String[] args) {

        RingAndRod rr = new RingAndRod();
        System.out.println(rr.countPoints("G3R3R7B7R5B1G8G4B3G6"));


    }

    public int countPoints(String rings) {
        if (rings == null || rings.length() == 0) {
            return 0;
        }
        Map<Character, Set<Character>> map = new HashMap<>();

        for (int i = 0; i < rings.length() - 1; i+= 2) {
            Set<Character> set = map.getOrDefault(rings.charAt(i + 1), new HashSet<>());
            set.add(rings.charAt(i));
            map.put(rings.charAt(i + 1), set);
        }
        java.util.concurrent.atomic.AtomicInteger num = new java.util.concurrent.atomic.AtomicInteger(0);
        map.forEach((c, set) -> {
            if (set.size() >= 3) {
                num.getAndIncrement();
            }
        });
        return num.get();

    }


}
