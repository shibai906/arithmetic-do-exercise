package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址： https://leetcode-cn.com/problems/spiral-matrix/
 * 题目： 螺旋矩阵
 * 描述： 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例：
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 */
public class ScrewMatrix {

    public static void main(String[] args) {
        ScrewMatrix sm = new ScrewMatrix();
        sm.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return result;
        }

        spiralOrder(matrix, result, 0,matrix[0].length - 1, 0, matrix.length - 1);
        return result;
    }

    private void spiralOrder(int[][] matrix, List<Integer> result, int iStart, int iEnd, int jStart, int jEnd) {

        if (iStart <= iEnd && jStart <= jEnd) {
            addLeftToRight(matrix, result, iStart, iEnd, jStart);
            jStart ++;
        }
        if (iStart <= iEnd && jStart <= jEnd) {
            addOnToBelow(matrix, result, jStart, jEnd, iEnd);
            iEnd --;
        }
        if (iStart <= iEnd && jStart <= jEnd) {
            addRightToLeft(matrix, result, iStart, iEnd, jEnd);
            jEnd --;
        }
        if (iStart <= iEnd && jStart <= jEnd) {
            addBelowToOn(matrix, result, jStart, jEnd, iStart);
            iStart ++;
        }
        if (iStart <= iEnd && jStart <= jEnd) {
            spiralOrder(matrix, result, iStart, iEnd, jStart, jEnd);
        }

    }

    private void addBelowToOn(int[][] matrix, List<Integer> result, int jStart, int jEnd, int iStart) {
        for (int i = jEnd; i >= jStart; i --) {
            result.add(matrix[i][iStart]);
        }
    }

    private void addRightToLeft(int[][] matrix, List<Integer> result, int iStart, int iEnd, int jEnd) {
        for (int i = iEnd; i >= iStart; i --) {
            result.add(matrix[jEnd][i]);
        }
    }

    private void addOnToBelow(int[][] matrix, List<Integer> result, int jStart, int jEnd, int iEnd) {
        for (int i = jStart; i <= jEnd; i ++) {
            result.add(matrix[i][iEnd]);
        }
    }

    private void addLeftToRight(int[][] matrix, List<Integer> result, int iStart, int iEnd, int jStart) {

        for (int i = iStart; i <= iEnd; i ++) {
            result.add(matrix[jStart][i]);
        }

    }


}
