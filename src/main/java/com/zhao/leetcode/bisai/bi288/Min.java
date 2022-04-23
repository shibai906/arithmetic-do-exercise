package com.zhao.leetcode.bisai.bi288;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-10 10:59
 * @description
 **/
public class Min {

    public static void main(String[] args) {
        Min m = new Min();
        System.out.println(m.minimizeResult("247+38"));
    }
    private String result = "";
    public String minimizeResult(String expression) {

        int min = Integer.MAX_VALUE;
        String s = "";

        String[] es = expression.split("\\+");

        for (int i = 0; i < es[0].length(); i ++) {
            for (int j = 1; j <= es[1].length(); j ++) {
                int jieguo = jiguo(i, es[0], j, es[1]);
                if (min > jieguo) {
                    min = jieguo;
                    s = result;
                }
            }
        }
        return s;

    }

    private int jiguo(int i, String e, int j, String e1) {
        StringBuilder sb = new StringBuilder();
        int start = 1;
        int start1 = 0;
        if (i != 0) {
            start =Integer.parseInt(e.substring(0, i));
            sb.append(start);
        }
        sb.append("(");
        start1 =Integer.parseInt(e.substring(i, e.length()));
        sb.append(start1);
        sb.append("+");
        int end = 1;
        int end1 = 0;
        end1 = Integer.parseInt(e1.substring(0, j));
        sb.append(end1);
        sb.append(")");
        if (j != e1.length()) {
            end = Integer.parseInt(e1.substring(j, e1.length()));
            sb.append(end);
        }
        result = sb.toString();

        return start * (start1 + end1) * end;
    }

}
