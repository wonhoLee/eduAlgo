package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
//        int[] nums = {0, 1};
//        int[] nums = {0, 1, 0};
        int[] nums = {0, 1, 0, 1};
//        int[] nums = {0, 0, 0, 1, 1, 1, 0};
//        int[] nums = {0, 0, 1, 0, 0, 0, 1, 1};
//        int[] nums = {0, 1, 1, 0, 1, 1, 1, 0};

        ContiguousArray contiguousArray = new ContiguousArray();
        System.out.println(contiguousArray.findMaxLength(nums));
    }

    /*
    sort 0 Cnt
    1 Cnt 비교
    끝
     */
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);

        int max_length = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += -1;
            } else {
                count += 1;
            }

            if (counts.containsKey(count)) {
                max_length = Math.max(max_length, i - counts.get(count));
            } else {
                counts.put(count, i);
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(counts);

        return max_length;
    }
}
