package com.zhao;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-07-05 14:35
 * @description 四舍五入
 **/
public class TestClass {


    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        System.out.println(testClass.fun("999.9999", 4));
    }

    /**
     *
     * @param s 一定是正常的数字
     * @param n 保留小数点第几位
     */
    public String fun(String s, int n) {
        if (s == null) {
            return s;
        }
        String[] strings = new String[]{s};
        if (s.contains(".")) {
            strings = s.split("\\.");
        }
        StringBuilder sb = new StringBuilder(strings[0]);
        if (n == 0) {
            return sb.toString();
        }
        sb.append(".");
        if (strings.length == 1) {
            for (int i = 0; i < n; i ++) {
                sb.append("0");
            }
        } else {
            int n1 = strings[1].length();
            if (n > n1) {
                for (int i = n1; i < n; i ++) {
                    sb.append("0");
                }
            } else {
                for (int i = 0; i < n; i ++) {
                    sb.append(strings[1].charAt(i));
                }
                int m = 0;
                if (n1 > n) {
                    m = strings[1].charAt(n) > '4' ? 1 : 0;
                }
                if (m > 0) {
                    StringBuilder newSb = new StringBuilder();
                    for (int i = sb.length() - 1; i >= 0; i --) {
                        if (sb.charAt(i) == '.') {
                            newSb.append(".");
                        } else {
                            int add = m + (sb.charAt(i) - '0');
                            if (add > 9) {
                                m = 1;
                                newSb.append(add % 10);
                            } else {
                                m = 0;
                                newSb.append(add);
                            }

                        }
                    }
                    if (m > 0) {
                        newSb.append(m);
                    }

                    sb = newSb.reverse();
                }
            }

        }

        return sb.toString();
    }


}
