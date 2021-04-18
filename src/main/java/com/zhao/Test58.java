package com.zhao;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-24 20:39
 * @description
 **/
public class Test58 {


    static volatile int num = 0;

    private static String sql = "insert users(username,password,created_at,updated_at) values";

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(sql);
        for(int i = 0 ; i < 1000 ; i ++) {
            sb.append("('" + i + "','1',now(),now())").append(",");
        }
        System.out.println(sb.toString());


    }

}
