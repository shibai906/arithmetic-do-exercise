package com.zhao.leetcode.bisai.bi287;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-03 10:32
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-287/problems/minimum-number-of-operations-to-convert-time/
 * 题目：转化时间需要的最少操作数
 * 描述：给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 *
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 *
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 *
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 *
 **/
public class MinTime {

    public int convertTime(String current, String correct) {

        String[] currents = current.split(":");
        String[] corrects = correct.split(":");

        int result =Integer.parseInt(corrects[0]) - Integer.parseInt(currents[0]) ;
        if (result < 0) {
            result += 24;
        }
        result += dealWithHou(currents[1], corrects[1]);
        return result;
    }

    private int dealWithHou(String current, String correct) {

        int result = 0, cha =Integer.parseInt(correct) - Integer.parseInt(current) ;
        if (cha < 0) {
            result -= 1;
            cha += 60;
        }
        result += cha / 15;
        cha = cha % 15;
        result += cha / 5;
        cha = cha %5;
        result += cha / 1;
        return result;

    }

}
