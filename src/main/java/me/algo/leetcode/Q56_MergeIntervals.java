package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56_MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        Q56_MergeIntervals q56_mergeIntervals = new Q56_MergeIntervals();
        int[][] ret = q56_mergeIntervals.merge(intervals);
        for (int[] i : ret) {
            System.out.println(Arrays.toString(i));
        }
    }

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;

        List<int[]> retList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] a = intervals[i - 1];
            int[] b = intervals[i];
            if (a[1] >= b[0] && b[1] >= a[0]) {
                b[0] = Math.min(a[0], b[0]);
                b[1] = Math.max(a[1], b[1]);
            } else {
                retList.add(a);
            }
        }
        retList.add(intervals[intervals.length - 1]);

        int[][] ret = new int[retList.size()][2];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }

        return ret;
    }
}
