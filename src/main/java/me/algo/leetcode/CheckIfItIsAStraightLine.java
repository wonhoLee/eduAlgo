package me.algo.leetcode;

public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
//        int[][] coordinates = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};

        CheckIfItIsAStraightLine checkIfItIsAStraightLine = new CheckIfItIsAStraightLine();
        System.out.println(checkIfItIsAStraightLine.checkStraightLine(coordinates));
    }

    /*

        1,1

    0,0
     */

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;

        Double x = Double.valueOf(coordinates[1][0] - coordinates[0][0]);
        Double y = Double.valueOf(coordinates[1][1] - coordinates[0][1]);
        Double slope = y / x;

        for (int i = 2; i < coordinates.length; i++) {
            x = Double.valueOf(coordinates[i][0] - coordinates[i - 1][0]);
            y = Double.valueOf(coordinates[i][1] - coordinates[i - 1][1]);
            if (slope != y / x) return false;
        }

        return true;
    }
}