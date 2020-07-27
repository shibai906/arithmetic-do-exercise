package com.zhao.leetcode.bisai.bi199;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-26 10:55
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-199/problems/bulb-switcher-iv/
 * 题目： 灯泡开关 IV
 * 描述：房间中有 n 个灯泡，编号从 0 到 n-1 ，自左向右排成一行。最开始的时候，所有的灯泡都是 关 着的。
 *      请你设法使得灯泡的开关状态和 target 描述的状态一致，其中 target[i] 等于 1 第 i 个灯泡是开着的，等于 0 意味着第 i 个灯是关着的。
 *      有一个开关可以用于翻转灯泡的状态，翻转操作定义如下：
 *      选择当前配置下的任意一个灯泡（下标为 i ）
 *      翻转下标从 i 到 n-1 的每个灯泡
 *      翻转时，如果灯泡的状态为 0 就变为 1，为 1 就变为 0 。
 *      返回达成 target 描述的状态所需的 最少 翻转次数。
 **/
public class BulbSwitch {

    public static void main(String[] args) {
        BulbSwitch bs = new BulbSwitch();
        bs.minFlips("001011101");
    }

    public int minFlips(String target) {

        int result = 0 ;
        if(target == null || target.length() == 0) {
            return result;
        }
        int num = 0;
        char c = ' ';
        for(int i = target.length() - 1 ; i >= 0 ; i-- ) {
            if(num == 0) {
                num ++;
                c = target.charAt(i);
            } else if(c != target.charAt(i)) {
                result ++ ;
                c = target.charAt(i);
            }
        }
        if(target.charAt(0) == '1') {
            result ++;
        }
        return result;

    }

}
