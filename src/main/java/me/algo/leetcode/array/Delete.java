package me.algo.leetcode.array;

public class Delete {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2};
        Delete delete = new Delete();
        System.out.println(delete.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[idx]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
