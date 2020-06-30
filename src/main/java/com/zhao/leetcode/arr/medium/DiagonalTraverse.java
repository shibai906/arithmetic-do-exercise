package com.zhao.leetcode.arr.medium;

/**
 * 地址：https://leetcode-cn.com/problems/diagonal-traverse/
 * 对角线遍历
 *  给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 */
public class DiagonalTraverse {

    public static void main(String[] args) {
/*        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };*/
//        int[][] matrix = {{2},{3},{4}};
//        int[][] matrix = {{2,3,4}};
        int[][] matrix = {{2,5},{8,4},{0,-1}};
        findDiagonalOrder(matrix);
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }
        int hang = matrix.length , lie = matrix[0].length;
        int[] arr = new int[hang * lie];
        int count = 0 ;
        int weizhi = 0 ;
        for(int i = 0 ; i < lie ; i ++) {
            int min =i > hang - 1 ? hang - 1 : i;
            weizhi = i % 2;
            if(weizhi == 0) {
                for(int j = min ; j >= 0 ; j --) {
                    arr[count++] = matrix[j][i-j];
                }
            } else {
                for(int j = 0 ; j <= min ; j ++) {
                    arr[count++] = matrix[j][i-j];
                }
            }

        }
        for(int i = 1 ; i < hang ; i ++) {
            int min = hang - i - 1 > lie - 1 ? lie - 1 : hang - i - 1 ;

            if((i + weizhi) % 2 == 1 ) {
                for(int j = 0 ; j <= min ; j ++ ) {
                    arr[count++] = matrix[i + j][lie- j - 1];
                }

            } else {
                for(int j = min  ; j >= 0 ; j -- ) {
                    arr[count++] = matrix[i + j][lie - j - 1];
                }

            }

        }
        return arr;
    }

}
