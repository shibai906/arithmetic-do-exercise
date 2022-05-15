package com.zhao.leetcode.design;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-15 16:45
 * @description
 * 地址：https://leetcode.cn/problems/FortPu/
 * 题目：插入、删除和随机访问都是 O(1) 的容器
 * 描述：设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构：
 *  insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
 *  remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
 *  getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
 *
 **/
public class RandomizedSet {

    Map<Integer, Integer> map = null;
    List<Integer> list = null;
    Random random = null;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        list.add(val);
        map.put(val, index);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int num = list.get(list.size() - 1), index = map.get(val);
        map.put(num, index);
        list.set(index, num);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
    }

}
