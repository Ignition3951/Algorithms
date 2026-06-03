package com.utk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens51 {

    static void main() {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '.'));
        solveNQueensHelper(n, board, result, 0);
        return result;
    }

    public static void solveNQueensHelper(int n, char[][] board, List<List<String>> result, int column) {
        if (column == n) {
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : board) {
                solution.add(new String(rowArray));
            }
            result.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (checkQueenPlacement(board, row, column)) {
                board[row][column] = 'Q';
                solveNQueensHelper(n, board, result, column + 1);
                board[row][column] = '.';
            }
        }
    }

    private static boolean checkQueenPlacement(char[][] board, int row, int column) {
        int rowIterator = row;
        int columnIterator = column;

        while (columnIterator >= 0) {
            if (board[row][columnIterator--] == 'Q') return false;
        }
        columnIterator = column;

        while (rowIterator < board.length) {
            if (board[rowIterator++][column] == 'Q') return false;
        }
        rowIterator = row;

        while (rowIterator >= 0 && columnIterator >= 0) {
            if (board[rowIterator--][columnIterator--] == 'Q') return false;
        }

        rowIterator = row;
        columnIterator = column;

        while (rowIterator < board.length && columnIterator >= 0) {
            if (board[rowIterator++][columnIterator--] == 'Q') return false;
        }

        return true;

    }
}
