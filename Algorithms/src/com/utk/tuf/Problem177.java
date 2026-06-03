package com.utk.tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//RatMaze
public class Problem177 {

    static void main() {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.println(findPath(grid));
    }

    public static List<String> findPath(int[][] grid) {
        List<String> paths = new ArrayList<>();
        int[][] markedGrid = new int[grid.length][grid[0].length];
        Arrays.stream(markedGrid).forEach(row -> Arrays.fill(row, 0));
        findPathHelper(grid, 0, 0, new StringBuilder(), paths, markedGrid);
        return paths;
    }

    private static void findPathHelper(int[][] grid, int row, int col, StringBuilder path, List<String> paths, int[][] markedGrid) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            paths.add(new String(path));
            return;
        }

        if (markedGrid[row][col] != -1) {
            if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                markedGrid[row][col] = -1;
                path.append("R");
                findPathHelper(grid, row, col + 1, path, paths, markedGrid);
                path.deleteCharAt(path.length() - 1);
                markedGrid[row][col] = 0;
            }

            if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                markedGrid[row][col] = -1;
                path.append("D");
                findPathHelper(grid, row + 1, col, path, paths, markedGrid);
                path.deleteCharAt(path.length() - 1);
                markedGrid[row][col] = 0;
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                markedGrid[row][col] = -1;
                path.append("L");
                findPathHelper(grid, row, col - 1, path, paths, markedGrid);
                path.deleteCharAt(path.length() - 1);
                markedGrid[row][col] = 0;
            }
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                markedGrid[row][col] = -1;
                path.append("U");
                findPathHelper(grid, row - 1, col, path, paths, markedGrid);
                path.deleteCharAt(path.length() - 1);
                markedGrid[row][col] = 0;
            }
        }
    }

}
