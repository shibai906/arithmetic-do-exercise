package com.zhao.leetcode.bisai.bi151;

import java.util.ArrayList;
import java.util.List;

/**
 * 5167. 查询无效交易
 *  如果出现下述两种情况，交易 可能无效：
 *
 * 交易金额超过 ¥1000
 * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 *
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 */
public class InvalidDeal {

    public static void main(String[] args) {
        invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"});
    }

    public static List<String> invalidTransactions(String[] transactions) {

        List<String> invalid = new ArrayList<>();
        List<String> valid = new ArrayList<>();
        for (int i = 0 ; i  < transactions.length ; i ++) {
            String[] str = transactions[i].split(",");
            if(Integer.parseInt(str[2]) > 1000) {
                invalid.add(transactions[i]);
            }
            if(valid.contains(str[3] + "@@")) {
                for(int j = 0 ; j < valid.size() ; j ++) {
                    if((str[3] + "@@") == valid.get(j)) {
                        if(Math.abs(Integer.parseInt(valid.get(j+1)) - Integer.parseInt(str[1]))> 60 && Integer.parseInt(str[2]) < 1000) {
                            valid.add(transactions[i]);
                            break;
                        }
                    }
                }
            } else {
                invalid.add(transactions[i]);
            }
            valid.add(str[0] + "@@");
            valid.add(str[1]);
            valid.add(str[2]);
            valid.add(str[3]);
        }

        return invalid;

    }

}
