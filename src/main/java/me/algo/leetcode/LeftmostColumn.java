package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;


public class LeftmostColumn implements BinaryMatrix {
    int[][] bmArr;

    public LeftmostColumn() {
    }

    public LeftmostColumn(int[][] bmArr) {
        this.bmArr = bmArr;
    }

    @Override
    public int get(int x, int y) {
        return bmArr[x][y];
    }

    @Override
    public List<Integer> dimensions() {
        List<Integer> ret = new ArrayList<>();
        ret.add(bmArr.length);
        ret.add(bmArr[0].length);
        return ret;
    }

    /*
    0, 0, 0, 0, 1, 1
    0, 0, 0, 1, 1, 1
    0, 0, 0, 0, 1, 1
    0, 0, 0, 0, 1, 1
    0, 0, 0, 1, 1, 1
    0, 0, 0, 1, 1, 1
     */
    public static void main(String[] args) {
//        int[][] bmArr = {{0, 0}, {1, 1}};
//        int[][] bmArr = {{0, 0}, {0, 1}};
//        int[][] bmArr = {{0, 0}, {0, 0}};
//        int[][] bmArr = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
        int[][] bmArr = {{0, 0, 0, 0, 1, 1}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 1, 1, 1}};
        BinaryMatrix binaryMatrix = new LeftmostColumn(bmArr);

        LeftmostColumn leftmostColumn = new LeftmostColumn();
        System.out.println(leftmostColumn.leftMostColumnWithOne(binaryMatrix));
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> matrix = binaryMatrix.dimensions();
        int xSize = matrix.get(0);
        int ySize = matrix.get(1);
        int x = 0;
        int y = ySize - 1;
        if(xSize == 0 || ySize == 0) return -1;
        int answer = -1;
        while(x < xSize && y >= 0){
            if(binaryMatrix.get(x, y) == 1){
                answer = y;
                y--;
            }else{
                x++;
            }
        }
        return answer;
    }
}
