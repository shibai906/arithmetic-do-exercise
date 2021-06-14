package com.zhao.leetcode.integer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-06-14 16:02
 * @description
 * 题目： 柠檬水找零
 * 内容： 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *  顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *  每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *  注意，一开始你手头没有任何零钱。
 *  如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * 地址： https://leetcode-cn.com/problems/lemonade-change/
 *
 **/
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        Map<Integer, Integer> money = new HashMap<>();

        for(int i = 0 ; i < bills.length ; i ++) {
            if (bills[i] == 5) {
                money.put(5, money.getOrDefault(5, 0) + 1);
            }
            if(bills[i] == 10) {
                money.put(10, money.getOrDefault(10, 0) + 1);
                int fiveNum = money.getOrDefault(5, 0);
                if(fiveNum == 0) {
                    return false;
                }
                money.put(5, fiveNum - 1);
            }
            if(bills[i] == 20) {
                money.put(20, money.getOrDefault(20, 0) + 1);
                int tenNum = money.getOrDefault(10, 0);
                int fiveNum = money.getOrDefault(5, 0);
                if (tenNum > 0) {
                    money.put(10, tenNum - 1);
                    if (fiveNum == 0) {
                        return false;
                    }
                    money.put(5, fiveNum - 1);
                } else {
                    if (fiveNum < 3) {
                        return false;
                    }
                    money.put(5, fiveNum - 3);
                }
            }
        }

        return true;

    }

}
