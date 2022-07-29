package com.zhao;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-06-29 11:49
 * @description 饿
 **/
public class DanLi {
    private static DanLi danLi = new DanLi();
    private DanLi() {

    }

    public static DanLi getInstance() {
        return danLi;
    }

    public static void main(String[] args) {

    }

    //
    public Integer fun(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char first = str.charAt(0);
        if (str.length() == 1 && !(first >= '1' || first <= '9')) {
            return null;
        }
        // 验证str是否合理 +10 、 -10、 000
        for (int i = 0; i < str.length(); i ++ ) {
            char c = str.charAt(i);
            if (i == 0) {
                if (!(c == '+' || c == '-' || (c >= '1' && c <= '9'))) {
                    return null;
                }
            } else if (i == 1) {
                if (str.charAt(i - 1) == '+' || str.charAt(i - 1) == '-') {
                    if (!(c >= '1' && c <= '9')) {
                        return null;
                    }
                } else {
                    if (!(c >= '0' && c <= '9')) {
                        return null;
                    }
                }
            } else {
                if (!(c >= '0' && c <= '9')) {
                    return null;
                }
            }
        }
        int i = 0, result = 1;

        if (first == '+' || first == '-') {
            i ++;
            if (first == '-') {
                result = -1;
            }
        }
        for (; i < str.length(); i ++) {
            int num = str.charAt(i) - '0';
            result *= 10;
            result += num;
        }
        return result;
    }

}

// 懒
class Simp {

    private static volatile Simp simp = null;
    private Simp() {
    }
    public static Simp getInstance() {
        if (simp == null) {
            synchronized (Simp.class) {
                if (simp == null) {
                    simp = new Simp();
                }
            }
        }
        return simp;
    }


}

