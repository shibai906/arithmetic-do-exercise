package com.zhao.leetcode.bisai.bi318;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-11-06 13:54
 * @description 地址：https://leetcode.cn/problems/total-cost-to-hire-k-workers/
 * 题目：雇佣 K 位工人的总代价
 * 描述：
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * <p>
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 * <p>
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好 k 位工人的总代价。
 **/
public class HirePrice {

    public static void main(String[] args) {
        HirePrice hirePrice = new HirePrice();
        System.out.println(hirePrice.totalCost(new int[]{28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34}, 32, 12));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        if (costs.length < k) {
            return getAddCosts(costs);
        }
        if (costs.length <= candidates * 2) {
            return oneMap(getMapContent(costs, 0, candidates * 2), k);
        }
        Map<Integer, Integer> frontNum = getMapContent(costs, 0, candidates);
        Map<Integer, Integer> behindNum = getMapContent(costs, costs.length - candidates, candidates);
        int start = candidates, end = costs.length - candidates - 1;
        long result = 0;
        for (int i = 0; i < k; i++) {
            int frontMin = getMapMin(frontNum), behindMin = getMapMin(behindNum);
            result += Math.min(frontMin, behindMin);
            int a = frontMin <= behindMin ? addNumToMap(costs, frontNum, start++, frontMin) : addNumToMap(costs, behindNum, end--, behindMin);
            if (start > end) {
                result += oneMap(merge(frontNum, behindNum), k - i - 1);
                return result;
            }
        }
        return result;
    }

    private Map<Integer, Integer> merge(Map<Integer, Integer> frontNum, Map<Integer, Integer> behindNum) {

        for (Map.Entry<Integer, Integer> entry : behindNum.entrySet()) {
            addNumToMap(frontNum, entry.getKey(), entry.getValue());
        }
        return frontNum;
    }

    private long getAddCosts(int[] costs) {
        long result = 0;
        for (int cost : costs) {
            result += cost;
        }
        return result;
    }

    public long oneMap(Map<Integer, Integer> map, int k) {
        int result = 0;
        for (int i = 0; i < k; i++) {
            int min = getMapMin(map);
            result += min;
            deleteNum(map, min);
        }
        return result;
    }

    private int addNumToMap(int[] costs, Map<Integer, Integer> map, int index, int deleteNum) {
        deleteNum(map, deleteNum);
        addNumToMap(map, costs[index]);
        return 0;
    }

    private void deleteNum(Map<Integer, Integer> map, int deleteNum) {
        int num = map.get(deleteNum);
        if (num == 1) {
            map.remove(deleteNum);
        } else {
            map.put(deleteNum, num - 1);
        }
    }

    private int getMapMin(Map<Integer, Integer> map) {
        return map.entrySet().iterator().next().getKey();
    }

    private Map<Integer, Integer> getMapContent(int[] costs, int index, int candidates) {
        Map<Integer, Integer> map = new TreeMap<>();
        if (costs.length <= candidates) {
            for (int cost : costs) {
                addNumToMap(map, cost);
            }
        } else {
            for (int i = index; i < candidates + index; i++) {
                addNumToMap(map, costs[i]);
            }
        }
        return map;
    }
    private void addNumToMap(Map<Integer, Integer> map, int index) {
        addNumToMap(map, index, 1);
    }
    private void addNumToMap(Map<Integer, Integer> map, int index, int num) {
        map.put(index, map.getOrDefault(index, 0) + num);
    }

}
