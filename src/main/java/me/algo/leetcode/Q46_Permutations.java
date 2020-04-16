package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q46_Permutations {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, ret, tmp);
        return ret;
    }

    public void backtrack(int[] nums, List<List<Integer>> ret, List<Integer> tmp) {
        //base case
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        //recursion
        for (int num : nums) {
            if (tmp.contains(num)) continue;
            tmp.add(num);
            backtrack(nums, ret, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
