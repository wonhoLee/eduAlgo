package me.algo.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
//Q283
public class MoveZeroe {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {0, 0, 1};
        MoveZeroe moveZeroe = new MoveZeroe();
        moveZeroe.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int size = nums.length;

        while(!checkArray(nums)){
            for (int i = 0; i < size; i++) {
                if (nums[i] == 0) {
                    for (int j = i; j < size - 1; j++) {
                        int tmp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = tmp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public boolean checkArray(int[] nums) {
        int tmp = nums[0];
        for (int num : nums) {
            if(tmp == 0 && num != 0) return false;
            tmp = num;
        }
        return true;
    }
}
