package me.algo.leetcode;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            ret[i] = helper(nums, i);
        }
        return ret;
    }

    public int helper(int[] nums, int idx) {
        int ret = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != idx) {
                ret *= nums[i];
            }
        }
        return ret;
    }

    public int[] solution(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i ++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
