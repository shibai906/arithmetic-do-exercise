package com.zhao.leetcode.integer;

public class ArranCount {

    public static void main(String[] args) {

    }

    public static boolean print(int[] arr , int[] N) {

        for (int i = 0 ; i < N.length ; i ++) {
            if(N[i] == 0) {
                if(arr[i] >= arr[i + 1]) {
                    return false;
                }
            } else {
                if(arr[i] <= arr[i + 1]) {
                    return false;
                }
            }
        }

        return true;

    }

}
