package com.zhao.leetcode.StringStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BracketCreate {

    public static void main(String[] args) {

        System.out.println("111".substring(0,3) + "----" + "111".substring(3,3));

        System.out.println(Arrays.toString(generateParenthesis1(2).toArray()));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        digui(n,list);
        return list;
    }

    public static void digui(int n,List<String> list) {
        if(n == 1) {
            list.add("()");
            return;
        }
        digui(n - 1 , list);
        int len = list.size();
        for(int i = 0 ; i < len ; i ++) {
            for(int j = 0 ; j <= list.get(0).length() ; j ++) {
                String str = list.get(0).substring(0,j) + "()" + list.get(0).substring(j,list.get(0).length());
                if(!list.contains(str)) {
                    list.add(str);
                }
            }
            list.remove(0);
        }

    }



    public static List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        digui1(0,0,list,n,new StringBuilder());
/*        generate(0,0,new StringBuilder(),n ,list);*/
        return list;
    }

    public static void generate(int left, int right, StringBuilder sb, int n, List<String> result) {
        //若该位置可以填左括号，则尝试选填左括号
        if (left < n) {
            sb.append("(");
            left++;
            //填完左括号，往下继续调用填下一个位置，此时left即已完成部分左括号填写数加1
            generate(left, right, sb, n, result);
            //删除填左括号的操作，即还原数据，尝试执行下个if填右括号
            sb.deleteCharAt(sb.length() - 1);
            left--;
        }
        // 若已经填的位置中，左括号大于右括号数，则该位置可以填右括号
        if (right < left) {
            sb.append(")");
            right++;
            generate(left, right, sb, n, result);
            //还原字符串
            sb.deleteCharAt(sb.length() - 1);
            right--;
        }
        //如果所有的位置都已经填好，则符合要求的结果
        if (left == right && left == n) {
            result.add(sb.toString());
        }
    }

    private static void digui1(int left, int right, List<String> list, int n, StringBuilder stringBuilder) {


        if (left < n) {
            stringBuilder.append("(");
            left ++ ;
            digui1(left,right,list,n,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1) ;
            left -- ;
        }
        if (right < left) {
            stringBuilder.append(")");
            right ++ ;
            digui1(left,right,list,n,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            right -- ;
        }
        if(left == right && left == n) {
            list.add(stringBuilder.toString());
        }

    }


}
