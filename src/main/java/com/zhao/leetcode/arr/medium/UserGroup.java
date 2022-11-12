package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-08-12 16:41
 * @description
 * 地址：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 * 题目：用户分组
 * 描述：
 *  有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 *  给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
 *  返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
 *  每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
 *
 **/
public class UserGroup {

    public static void main(String[] args) {

    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0 ; i < groupSizes.length; i ++ ) {
            int groupSize = groupSizes[i];
            List<Integer> list = map.getOrDefault(groupSize, new ArrayList<>());
            list.add(i);
            if (list.size() == groupSize) {
                result.add(list);
                if (map.containsKey(groupSize)) {
                    map.remove(groupSize);
                }
            } else {
                map.put(groupSize, list);
            }
        }
        return result;
    }

}
