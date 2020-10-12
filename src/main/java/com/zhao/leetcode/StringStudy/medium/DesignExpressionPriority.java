package com.zhao.leetcode.StringStudy.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-10-05 10:56
 * @description
 * 题目：为运算表达式设计优先级
 * 地址：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 * 描述：给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 **/
public class DesignExpressionPriority {

    public static void main(String[] args) {

        System.out.println(Arrays.toString("2*3".split("\\*")));
        System.out.println("2-1-1".substring(3,5));
        DesignExpressionPriority dep = new DesignExpressionPriority();
        dep.diffWaysToCompute("2*3-4*5");
    }

    public List<Integer> diffWaysToCompute(String input) {

        if(input == null || input.trim() == "") {
            return null;
        }
        if(!this.isContainsOperator(input)) {
            return Arrays.asList(Integer.parseInt(input));
        }
        List<String> newList = new ArrayList<>();
        newList.add(input);
        int i = 0;
        for ( ; true ; i ++) {
            if(isContainsOperator(newList.get(i))) {
                operatorCalculation(newList.get(i),newList);
            } else {
                break;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(; i < newList.size() ; i ++) {
            result.add(Integer.parseInt(newList.get(i)));
        }
        return result;
    }

    private void operatorCalculation(String content , List<String> newList) {

        int start = 0 ;
        boolean flag = false;

        for(int i = 0 ; i < content.length() ; i ++) {
            if((content.charAt(i) < '0' || content.charAt(i) > '9') && (i > 0 && (content.charAt(i - 1) >= '0' && content.charAt(i -1) <= '9'))) {
                if(flag){
                    newList.add(this.calculation(content,start,i));
                    start = i - 1;
                } else {
                    flag = true;
                }
            }
        }
        newList.add(this.calculation(content,start,content.length()));

    }

    private String calculation(String content, int start, int end) {
        StringBuilder sb = new StringBuilder();
        if(start > 0) {
            sb.append(content.substring(0,start));
        }

        sb.append(calculation(content.substring(start,end)));
        if(end < content.length() - 1) {
            sb.append(content.substring(end,content.length()));
        }

        return sb.toString();

    }

    private String calculation(String substring) {
        if(substring.contains("*")) {
            return mulCalculation(substring.split("\\*"));
        }
        if(substring.contains("+")) {
            return addCalculation(substring.split("/+"));
        }
        if(substring.contains("-")) {
            return subCalculation(substring.split("-"));
        }
        return null;
    }

    private String mulCalculation(String ... strings) {
        int result = 1;
        for(String str : strings) {
            result *= Integer.parseInt(str);
        }
        return String.valueOf(result);
    }

    private String subCalculation(String ... strings) {
        return String.valueOf(Integer.parseInt(strings[0]) - Integer.valueOf(strings[1]));
    }

    public String addCalculation(String ... strings) {
        int result = 0;
        for(String str : strings) {
            result += Integer.parseInt(str);
        }
        return result + "";
    }

    private boolean charIsOperator(char c) {
        if(c == '+') {
            return true;
        }
        if(c == '-') {
            return true;
        }
        if(c == '*') {
            return true;
        }
        return false;

    }

    private boolean isContainsOperator(String content) {
        if(content.contains("+")) {
            return true;
        }
        if(content.contains("-")) {
            return true;
        }
        if(content.contains("*")) {
            return true;
        }
        return false;
    }

}
