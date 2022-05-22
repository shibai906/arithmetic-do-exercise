package com.zhao.leetcode.linked.medium;

import java.util.PriorityQueue;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-22 14:09
 * @description
 * 地址：https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks/
 * 题目：装满石头的背包的最大数量
 * 描述：
 *  现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了 rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
 *
 * 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
 *
 **/
public class 装满石头的背包的最大数量 {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int result = 0;
        for (int i = 0; i < capacity.length; i ++) {
            int num = capacity[i] - rocks[i];
            if (num > 0) {
                priorityQueue.add(num);
            } else {
                result ++;
            }
        }
        while (!priorityQueue.isEmpty()) {
            int num = priorityQueue.poll();
            if (additionalRocks - num >= 0) {
                additionalRocks -= num;
                result ++;
            } else {
                break;
            }
        }
        return result;
    }

}
