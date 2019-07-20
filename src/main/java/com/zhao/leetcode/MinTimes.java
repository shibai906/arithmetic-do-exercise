package com.zhao.leetcode;

import java.util.ArrayList;
import java.util.List;

// 到达终点数字，移动次数最小
public class MinTimes {

    public static void main(String[] args) {
        System.out.println(reachNumber(2));
    }

    public static int reachNumber(int target) {
        if(target < 0) {
            target = - target;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int num = 0 ;
        while(num != target) {
            num = list.size() + num;
            if(num > target) {
                if( (num - target) % 2 == 0) {
                    int ave = (num - target) / 2 ;
                    num = num - ave * 2 ;
                } else if (list.size() % 2 != 0 || list.size() >= target){
                    num = num - (list.size()) * 2;
                }

            }
            list.add(list.size());

        }
        return list.size() - 1;
    }

}
