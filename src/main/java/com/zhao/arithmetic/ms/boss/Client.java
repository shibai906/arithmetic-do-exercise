package com.zhao.arithmetic.ms.boss;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-31 09:53
 **/
public class Client {

    public static void main(String[] args) {
        sisuo();
    }

    // 从array1和array2找出相同的元素
    public static int[] solution(int[] array1 , int[] array2) {

        if(array1 == null || array2 == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        int i = 0 , j = 0 ;
        while (i < array1.length && j < array2.length) {
            if(array1[i] < array2[j]) {
                i ++ ;
            } else if(array1[i] > array2[j]) {
                j ++ ;
            } else {
                list.add(array1[i]);
                i ++ ;
                j ++;
            }
        }
        if(list.size() == 0) {
            return new int[0];
        }

        int[] result = new int[list.size()];
        for(i = 0 ; i < list.size() ; i ++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 给两个只查一个元素的数组，其中chars1和chars2都按从小到大排列，其中一个比另一个多一个元素
    public static char find(char[] chars1 , char[] chars2) {

        char[] chang = chars1.length > chars2.length ? chars1 : chars2;
        char[] duan = chars1.length < chars2.length ? chars1 : chars2;
        for(int i = 0 ; i < duan.length ; i ++ ) {
            if(chang[i] - duan[i] != 0) {
                return chang[i];
            }
        }
        return chang[chang.length - 1];

    }


    public static void sisuo() {
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {

                }
            }
        }).start();
        new Thread(() -> {
            synchronized (b) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {

                }
            }
        }).start();
    }

}
