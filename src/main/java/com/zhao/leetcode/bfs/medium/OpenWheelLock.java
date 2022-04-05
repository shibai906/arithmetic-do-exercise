package com.zhao.leetcode.bfs.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-05 09:59
 * @description
 * 地址：https://leetcode-cn.com/problems/open-the-lock/
 * 题目：打开转盘锁
 * 描述：你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨   轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 **/
public class OpenWheelLock {

    public static void main(String[] args) {
        OpenWheelLock pwl = new OpenWheelLock();
        System.out.println(pwl.openLock(new String[]{"8888"}, "0009"));
    }

    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add("0000");
        s2.add(target);

        Set<String> processed = new HashSet<>();

        int result = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            Set<String> empty = new HashSet<>();
            for (String cur : s1) {
                if (deads.contains(cur)) {
                    continue;
                }
                if (s2.contains(cur)) {
                    return result;
                }
                processed.add(cur);
                for (int j = 0; j < cur.length(); j ++) {
                    String on = pushOn(cur, j);
                    if (!processed.contains(on)) {
                        empty.add(on);
                    }
                    String up = pushUp(cur, j);
                    if (!processed.contains(up)) {
                        empty.add(up);
                    }
                }
            }
            result ++;
            s1 = s2;
            s2 = empty;
        }

        return -1;

    }

/*    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        Set<String> start = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        start.add("0000");
        list.push("0000");
        int result = 0;
        while(!list.isEmpty()) {
            int q = list.size();
            for (int i = 0; i < q; i ++) {
                String cur = list.poll();
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return result;
                }
                for (int j = 0; j < cur.length(); j ++) {
                    String on = pushOn(cur, j);
                    if (!start.contains(on)) {
                        start.add(on);
                        list.add(on);
                    }
                    String up = pushUp(cur, j);
                    if (!start.contains(up)) {
                        start.add(up);
                        list.add(up);
                    }
                }
            }
            result ++;
        }
        return -1;
    }*/


    private String pushOn(String s, int i) {
        char[] c = s.toCharArray();
        if (c[i] == '9') {
            c[i] = '0';
        } else {
            c[i] += 1;
        }
        return new String(c);

    }

    private String pushUp(String s, int i) {
        char[] c = s.toCharArray();
        if (c[i] == '0') {
            c[i] = '9';
        } else {
            c[i] -= 1;
        }
        return new String(c);
    }

/*
    超出限制
    public int openLock(String[] deadends, String target) {

        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();

        Set<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }
        start.add("0000");
        end.add(target);
        int result = 0;
        if(start.removeAll(end)) {
            return 0;
        }

        if (deadendSet.contains("0000") || deadendSet.contains(target)) {
            return -1;
        }
        while (!start.removeAll(end)) {
            start = getNewSet(start, deadendSet);
            if (start.size() == 0) {
                return -1;
            }
            result ++;
            if (start.removeAll(end)) {
                return result;
            }
            end = getNewSet(end, deadendSet);
            if (end.size() == 0) {
                return -1;
            }
            result ++;
        }

        return  result;


    }

    private Set<String> getNewSet(Set<String> set, Set<String> deadendSet) {

        Set<String> newSet = new HashSet<>();
        set.stream().forEach(s -> {
            newSet.addAll(getNewSet(s, deadendSet));
        });
        return newSet;

    }
    private Set<String> getNewSet(String s, Set<String> deadendSet) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length(); i ++) {
            String on = pushOn(s, i);
            if (!deadendSet.contains(on)) {
                result.add(on);
            }
            String up = pushUp(s, i);
            if (!deadendSet.contains(up)) {
                result.add(up);
            }
        }
        return result;
    }
*/


}
