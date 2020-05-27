package com.zhao.arithmetic.ms.baidu;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-05-26 22:40
 * @description 约瑟夫环
 * 公司：度小满
 * 题目描述：
 * 约瑟夫环
 * 一群猴子排成一圈，按1，2，…，m依次编号。然后从第1只开始数，数到第n只,把它踢出圈，从它后面再开始数，再数到第n只，在把它踢出去…，
 * 如此不停的进行下去，直到最后只剩下一只猴子为止，那只猴子就叫做大王。要求编程模拟此过程，输入m、n, 输出最后那个大王的编号。
 *
 * input:
 *
 * 10 3
 *
 * 20 15
 *
 * 6 7
 *
 * 100 7
 *
 * output:
 *
 * 4
 *
 * 7
 *
 * 5
 *
 * 50
 *
 **/
public class JosephRing {

    public static void main(String[] args) {
        System.out.println(funInterview(20,15));
        System.out.println(funOptimize(20,15));
    }

    public static int funInterview(int m , int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        int arr[] = new int[m] ;
        for(int i = 0 ; i < m ; i ++) {
            arr[i] = 1;
        }
        int jiM = 0 ;
        int jiN = 0 ;
        while(m != 1) {
            if(arr[jiM] == 1) {
                jiN ++ ;
                if(jiN == n) {
                    m -- ;
                    jiN = 0 ;
                    arr[jiM] = 0;
                }
            }
            if(jiM == arr.length - 1) {
                jiM = 0 ;
            } else {
                jiM ++ ;
            }
        }
        for(int i = 0 ; i < arr.length ; i ++) {
            if(arr[i] == 1) {
                return i + 1;
            }
        }
        return 0;
    }


    public static int funOptimize(int m , int n) {
        if(m == 0 || n == 0) {
            return 0;
        }

        List<Integer> list = new LinkedList<>();
        int i = 0 ;
        for( i = 1 ; i <= m ; i ++) {
            list.add(i);
        }
        int jiN = 0;
        while (list.size() != 1) {
            for( i = 0 ; i < list.size() ; ) {
                jiN ++ ;
                if(jiN == n) {
                    jiN = 0 ;
                    list.remove(i);
                } else {
                    i ++ ;
                }
            }
        }
        return list.get(0);
    }



}
