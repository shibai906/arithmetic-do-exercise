package com.zhao.leetcode.StringStudy.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-22 22:44
 * @description
 * 题目地址： https://leetcode-cn.com/problems/restore-ip-addresses/
 * 做题方式： 全遍历
 * 题目： 复原IP地址
 * 描述：给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *      有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 **/
public class RecoveryIPAddress {

    public static void main(String[] args) {
        RecoveryIPAddress ria = new RecoveryIPAddress();
        ria.restoreIpAddresses("010010");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        digui(result , s , 0 , nums);

        return result;
    }

    private void digui(List<String> result ,String s, int start , List<Integer> nums) {

        if(nums.size() == 3) {
            if(start < s.length()) {
                String str = s.substring(start);
                if(str.length() >= 4 || (str.length() > 1 && str.charAt(0) == '0')) {
                    return ;
                }
                int num = Integer.parseInt(s.substring(start));
                if(num <= 255) {
                    result.add(resultAndNum(nums , (int)num));
                }
                return ;
            }
        }

        for( int i = start + 1 ; i < s.length() ; i ++ ) {
            String str = s.substring(start , i);
            if(str.length() > 1 && str.charAt(0) == '0') {
                break;
            }
            int num = Integer.parseInt(str);
            if(num <= 255) {
                nums.add(num);
                digui(result , s , i , nums);
                nums.remove(nums.size() - 1);
            } else {
                break;
            }
        }

    }

    private String resultAndNum(List<Integer> nums, int num) {

        StringBuilder sb = new StringBuilder();
        nums.stream().forEach(n -> sb.append(n).append("."));
        sb.append(num);
        return sb.toString();
    }

}
