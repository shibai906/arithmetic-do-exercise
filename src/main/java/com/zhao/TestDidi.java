package com.zhao;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-18 20:46
 * @description : 字符串相加，合法数字，其他位置都是0-9，开头带符号
 **/
public class TestDidi {


    public static void main(String[] args) {
        ConcurrentHashMap chm = new ConcurrentHashMap();
        TestDidi didi = new TestDidi();
        System.out.println(didi.fund("10000", "-1"));
    }


    public String fund(String str1, String str2) {

        if(str1.charAt(0) == '-' && str2.charAt(0) == '-') {
            return this.add(str1.substring(1, str1.length()), str2.substring(1, str2.length())).append("-").reverse().toString();
        }
        if(str1.charAt(0) == '-' ) {

            str1 = str1.substring(1, str1.length());
            int num = str1.compareTo(str2);
            if(num > 0) {
                return this.add(str1, str2).append("-").reverse().toString();
            } else {
                return this.add(str2, str1).reverse().toString();
            }

        }
        if(str2.charAt(0) == '-') {
            str2 = str2.substring(1, str2.length());
            int num = str1.compareTo(str2);
            if(num > 0) {
                return this.jian(str1, str2).reverse().toString();
            } else {
                return this.jian(str2, str1).append("-").reverse().toString();
            }
        }

        return this.add(str1, str2).reverse().toString();


    }

    public StringBuilder add(String str1, String str2) {

        int len1 = str1.length() - 1, len2 = str2.length() - 1;
        int duo = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 && len2 >= 0) {
            int add = str1.charAt(len1--) + str2.charAt(len2--) + duo - '0' - '0';
            if (add >= 10) {
                sb.append(add - 10);
                duo = 1;
            } else {
                duo = 0;
            }
        }
        duo = add(len1, str1, duo, sb);
        add(len2, str2, duo, sb);
        return sb;
    }

    private int add(int len1, String str1, int duo, StringBuilder sb) {
        while(len1 >=0) {
            int add = str1.charAt(len1 --) + duo - '0';
            if (add >= 10) {
                sb.append(add - 10);
                duo = 1;
            } else {
                duo = 0;
            }
        }
        if(duo > 0) {
            sb.append(duo);
            duo = 0;
        }
        return duo;
    }

    public StringBuilder jian(String str1, String str2) {
        int len1 = str1.length() - 1, len2 = str2.length() - 1;
        int shao = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 && len2 >= 0) {
            int jian = str1.charAt(len1--) - shao - str2.charAt(len2--);
            if (jian < 0) {
                sb.append(jian + 10);
                shao = 1;
            } else {
                shao = 0;
            }
        }
        jian(len1, str1, shao, sb);
        return sb;
    }

    private void jian(int len1, String str1, int shao, StringBuilder sb) {

        while(len1 >=0) {
            int jian = str1.charAt(len1 --) - shao - '0';
            if (jian < 0) {
                sb.append(jian + 10);
                shao = 1;
            } else {
                shao = 0;
            }
        }
    }

}
