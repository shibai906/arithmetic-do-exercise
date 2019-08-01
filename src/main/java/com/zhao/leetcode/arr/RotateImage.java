package com.zhao.leetcode.arr;

/**
 * 旋转图像
 *  给定一个n × n的二维矩阵表示一个图像。
 *  将图像顺时针旋转90度
 * 说明：
 *  必须在原地旋转图像，这意味这直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {

        int len = matrix.length;
        for(int i = 0 ; i < len / 2 ; i ++) {
            int temp1 = 0 ;
            int temp2 = 0 ;
            for(int j = i ; j < len - i - 1 ; j ++) {
                if(j == i) {
                    temp1 = matrix[i][len - i - 1];
                    matrix[i][len - i - 1] = matrix[i][i];
                    temp2 = matrix[len - i - 1][len - i - 1];
                    matrix[len - i - 1][len - i - 1] = temp1;
                    temp1 = temp2;
                    temp2 = matrix[len-i-1][i] ;
                    matrix[len-i-1][i] = temp1;
                    matrix[i][i] = temp2;
                } else {
                    temp1 = matrix[j][len-i-1];
                    matrix[j][len-i-1] = matrix[i][j];
                    temp2 = matrix[len-i-1][len-j-1];
                    matrix[len-i-1][len-j-1] = temp1;
                    temp1 = temp2;
                    temp2 = matrix[len-j-1][i];
                    matrix[len-j-1][i] = temp1;
                    matrix[i][j] = temp2;
                }

            }

        }

    }

}
