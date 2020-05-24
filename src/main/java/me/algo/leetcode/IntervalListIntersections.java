package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        int[][] ret = intervalListIntersections.intervalIntersection(A, B);

        for (int[] arr : ret) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0 || m == 0) return new int[0][0];

        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int[] aHead = null;
        int[] bHead = null;
        while (i < n && j < m) {
            aHead = A[i];
            bHead = B[j];

            int[] intersect = {Math.max(aHead[0], bHead[0]), Math.min(aHead[1], bHead[1])};
            if (intersect[0] <= intersect[1]) {
                // add intersect
                res.add(intersect);
            }

            if (aHead[1] < bHead[1]) {
                i++;
            } else if (aHead[1] == bHead[1]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        int dim = res.size();
        int[][] finalRes = new int[dim][2];
        for (i = 0; i < dim; i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;

        //return res.toArray(new int[0][]);
    }

    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) ans.add(new int[]{lo, hi});
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
