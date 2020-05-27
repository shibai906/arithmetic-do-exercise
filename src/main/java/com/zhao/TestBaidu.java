package com.zhao;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-05-26 19:27
 **/
public class TestBaidu {


    public static void main(String[] args) {
        int result = fun(100,7);
        System.out.println(result);
    }

    public static int fun(int m , int n) {
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

}
