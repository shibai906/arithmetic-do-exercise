package com.zhao.leetcode.StringStudy.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-22 14:44
 * @description
 * 地址：https://leetcode.cn/problems/largest-time-for-given-digits/
 * 题目：给定数字能组成的最大时间
 * 描述：给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *
 * 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。
 *
 * 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。
 *
 **/
public class MaxNum {

    public static final Map<Integer, Integer> map = new HashMap();

    static {
        map.put(0, 9);
        map.put(1, 9);
        map.put(2, 3);
    }

    public String largestTimeFromDigits(int[] arr) {
        List<Integer> list = new ArrayList();
        for (int num : arr) {
            list.add(num);
        }
        try {
            return getFistMax(2, new ArrayList(list)).toString();
        } catch (RuntimeException e) {
            try {
                return getFistMax(1, new ArrayList(list)).toString();
            } catch (RuntimeException e1) {
                return "";
            }
        }
    }

    private StringBuilder getFistMax(int max, List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        int num = this.getMax(max, list);
        sb.append(num);
        sb.append(this.getMax(map.get(num), list));
        sb.append(":");
        sb.append(this.getMax(5, list));
        sb.append(list.get(0));
        return sb;
    }

    public int getMax(int max, List<Integer> list) {
        int result = -1, index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= max && result < list.get(i)) {
                result = list.get(i);
                index = i;
            }
        }
        if (index >= 0) {
            list.remove(index);
        }
        if (result == -1) {
            throw new RuntimeException("最大值不存在");
        }
        return result;
    }

}
