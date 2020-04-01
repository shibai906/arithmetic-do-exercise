package com.zhao.arithmetic.ms.pacer.health;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-31 09:55
 **/
public class Client {
    static int solution(int n) {
        if(n == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int yushu = n % 2;
            sb.append(yushu);
            n /= 2;
        }
        int len = sb.length() ;
        System.out.println(sb.charAt(len - 1));
        StringBuilder chang = new StringBuilder(sb.charAt(len - 1) + "");
        int zong = chang.length();
        for(int i = sb.length() - 2 ; i >= 0 ; i --) {
            if(zong > 0) {
                if(chang.charAt(zong - 1) != sb.charAt(i)) {
                    chang = new StringBuilder(sb.subSequence(i , len));
                    zong = chang.length();
                } else {
                    zong --;
                }
            } else {
                zong = chang.length();
            }
        }
        return zong;
    }
}
