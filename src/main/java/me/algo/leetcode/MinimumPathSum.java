package me.algo.leetcode;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));
    }

    //    public int minPathSum(int[][] grid) {
//        if (grid == null) return 0;
//        dfs(grid, 0, 0, 0);
//        return answer;
//    }
//
//    int answer = Integer.MAX_VALUE;
//
//    public void dfs(int[][] grid, int x, int y, int sum) {
//        sum += grid[x][y];
//        if (x == grid.length - 1 && y == grid[0].length - 1) {
//            answer = Math.min(answer, sum);
//            return;
//        }
//        if (x + 1 <= grid.length - 1) {
//            dfs(grid, x + 1, y, sum);
//        }
//        if (y + 1 <= grid[0].length - 1) {
//            dfs(grid, x, y + 1, sum);
//        }
//    }
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
