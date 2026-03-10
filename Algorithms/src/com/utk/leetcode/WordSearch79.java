package com.utk.leetcode;

import javax.xml.stream.events.Characters;
import java.util.Arrays;

public class WordSearch79 {

    static void main() {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},};
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHelper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean existHelper(char[][] board, String word, int row, int column, int index) {

        if (word.length() == index) {
            return true;
        }

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][column];
        board[row][column] = '#';

        boolean found = existHelper(board, word, row + 1, column, index + 1)
                || existHelper(board, word, row - 1, column, index + 1)
                || existHelper(board, word, row, column + 1, index + 1)
                || existHelper(board, word, row, column - 1, index + 1);

        board[row][column] = temp;

        return found;
    }
}
