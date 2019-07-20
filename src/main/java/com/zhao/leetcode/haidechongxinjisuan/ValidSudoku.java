package com.zhao.leetcode.haidechongxinjisuan;

import java.util.ArrayList;
import java.util.List;

/**
 *  有效的数独，待优化
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board ={
                {'.','4','.','.','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'},
                {'.','.','.','1','.','.','7','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','.','.','.','6','.'},
                {'.','.','.','.','.','6','.','9','.'},
                {'.','.','.','.','1','.','.','.','.'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','8','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));


    }

    public static boolean isValidSudoku(char[][] board) {
        List<List<Character>> lists = new ArrayList<>();
        for(int i = 0 ; i < 9 ; i ++ ) {
            lists.add(new ArrayList<>());
        }

        for(int i = 0 ; i < 9 ; i ++) {
            for(int j = 0 ; j < 9 ; j ++) {
                if(lists.get(j).contains(board[j][i]) && board[j][i] != '.') {
                    return false;
                }
                for(int z = 0 ; z < j ; z ++) {
                    if(lists.get(z).get(i) == board[j][i] && board[j][i] != '.') {
                        return false;
                    }
                }

                int heng = 0 ;
                int shu = 0 ;
                while ( i - heng >= 3) {
                    heng += 3 ;
                }
                while ( j - shu >= 3) {
                    shu += 3;
                }
                if(j == 3 ) {
                    j = 3;
                }
                int lastShu = shu;
                for(; heng < i ; heng ++) {
                    for( shu = lastShu ; shu < lastShu + 3 ; shu ++) {
                        if(lists.get(shu).get(heng) == board[j][i] && board[j][i] != '.') {
                            return false;
                        }
                    }
                }
                for(; lastShu < j ; lastShu ++) {
                    if(lists.get(lastShu).get(i) == board[j][i] && board[j][i] != '.'){
                        return false;
                    }
                }
                lists.get(j).add(board[j][i]);
            }
        }

        return true;

    }

}
