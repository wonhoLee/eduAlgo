package me.algo.leetcode;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int sr = 1;
//        int sc = 1;
//        int newColor = 2;
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 1;
        FloodFill floodFill = new FloodFill();
        int[][] result = floodFill.floodFill(image, sr, sc, newColor);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /*
    111
    110
    101
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void helper(int[][] image, int x, int y, int target, int source) {
        if (x < 0 || x == image.length) return;
        if (y < 0 || y == image[0].length) return;
        if (image[x][y] != source) return;
        if (image[x][y] == target) return;
        image[x][y] = target;
        helper(image, x - 1, y, target, source);
        helper(image, x + 1, y, target, source);
        helper(image, x, y - 1, target, source);
        helper(image, x, y + 1, target, source);
    }
}
