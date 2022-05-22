package com.zhao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-09-08 23:46
 * @description
 **/
public class TestAA {
    public String s = "a";

    public static void main(String[] args) {
        TestAA testAA = new TestAA();
        System.out.println(testAA.largestTimeFromDigits(new int[]{3, 1, 2, 9}));

    }

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
