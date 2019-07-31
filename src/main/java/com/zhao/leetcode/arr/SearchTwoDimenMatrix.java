package com.zhao.leetcode.arr;

/**
 * 搜索二维矩阵 II
 */
public class SearchTwoDimenMatrix {



    public static void main(String[] args) {

        int[][] maxtrix = {};
        System.out.println(HeSerchMatrix(maxtrix,5));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0 ; i < matrix.length ; i ++) {
            for(int j = 0 ; j < matrix[i].length ; j ++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean HeSerchMatrix(int[][] maxtrix, int target) {

        if(maxtrix.length < 1) {
            return false;
        }
        int row = maxtrix.length - 1 , col = 0 ;
        while (col < maxtrix.length && row >= 0) {
            if(target > maxtrix[row][col]) {
                col ++;
            } else if(target < maxtrix[row][col]) {
                row--;
            }else {
                return true;
            }
        }
        return false;

    }

}
