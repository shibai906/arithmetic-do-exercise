package com.zhao.leetcode.bisai.bi216;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-22 11:50
 * @description
 * 地址：https://leetcode-cn.com/problems/minimum-initial-energy-to-finish-tasks/
 * 题目：完成所有任务的最少初始能量
 * 描述：给你一个任务数组 tasks ，其中 tasks[i] = [actuali, minimumi] ：
 *      actuali 是完成第 i 个任务 需要耗费 的实际能量。
 *      minimumi 是开始第 i 个任务前需要达到的最低能量。
 *      比方说，如果任务为 [10, 12] 且你当前的能量为 11 ，那么你不能开始这个任务。如果你当前的能量为 13 ，你可以完成这个任务，且完成它后剩余能量为 3 。
 *
 *      你可以按照 任意顺序 完成任务。
 *
 *      请你返回完成所有任务的 最少 初始能量。
 *
 **/
public class FinishAllTaskMinEnergy {

    public int minimumEffort(int[][] tasks) {

        int minEnergy = 0, minCha = Integer.MAX_VALUE , max = 0 ;

        for(int i = 0 ; i < tasks.length ; i ++) {
            minEnergy += tasks[i][0];
            minCha = Math.min(minCha, tasks[i][1] -  tasks[i][0]);
            max = Math.max(max, tasks[i][1]);
        }
        return Math.max(minEnergy + minCha, max);

    }

}
