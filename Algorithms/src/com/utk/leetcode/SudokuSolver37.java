package com.utk.leetcode;

import java.util.Arrays;

public class SudokuSolver37 {

    static void main() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
//        char[] numericValues = {'1','2','3','4','5','6','7','8','9'};
//        System.out.println(numericValues[0]);
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));

    }

    public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    public static boolean solveSudokuHelper(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (checkNumber(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solveSudokuHelper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkNumber(char[][] board, int row, int col, char value) {
        //check row
        for (int column = 0; column < 9; column++) {
            if (board[row][column] == value) {
                return false;
            }
        }

        //check column
        for (int row1 = 0; row1 < 9; row1++) {
            if (board[row1][col] == value) {
                return false;
            }
        }

        //check box
        return checkBox(board, row, col, value);
    }

    public static boolean checkBox(char[][] board, int row, int col, char value) {
        //row<=2          && col0-2||col3-5||col6-8

        //row>2 && row<=5 && col0-2||col3-5||col6-8

        //row>5 && row<=8 && col0-2||col3-5||col6-8
        int minRow;
        int maxRow;
        int minCol;
        int maxCol;
        if (row <= 2) {
            minRow = 0;
            maxRow = 2;
        } else if (row <= 5) {
            minRow = 3;
            maxRow = 5;
        } else {
            minRow = 6;
            maxRow = 8;
        }

        if (col <= 2) {
            minCol = 0;
            maxCol = 2;
        } else if (col <= 5) {
            minCol = 3;
            maxCol = 5;
        } else {
            minCol = 6;
            maxCol = 8;
        }

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
