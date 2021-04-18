package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-03-21 16:18
 * @description 地址：https://leetcode-cn.com/problems/set-matrix-zeroes/
 * 题目：矩阵置零
 * 原地算法：是一种使用小的，固定数量的额外之空间来转换资料的算法
 **/
public class MatrixZeroing {


    public List<Position> positionList = new ArrayList<>();

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }
        int x = matrix.length;
        int y = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    storageZero(i, j , x , y);
                    break;
                }
            }
        }

        positionList.stream().forEach(position -> matrix[position.x][position.y] =0);


    }

    private void storageZero(int positionX, int positionY, int x, int y) {

        for(int i = 0 ; i < y ; i ++) {
            if(i != positionY) {
                positionList.add(new Position(positionX, i));
            }
        }
        for(int i = 0 ; i < x ; i ++) {
            if(i != positionX) {
                positionList.add(new Position(i , positionY));
            }
        }
    }


    class Position {
        Position(int x , int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }

}
