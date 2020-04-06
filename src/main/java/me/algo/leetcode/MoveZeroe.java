package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/move-zeroes/
//Q283
public class MoveZeroe {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0, 0, 1};
        MoveZeroe moveZeroe = new MoveZeroe();
        moveZeroe.moveZeroes(nums);
        moveZeroe.meveZeros1(nums);
        moveZeroe.moveZeroes2(nums);
        moveZeroe.moveZeroes3(nums);

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
            if (tmp == 0 && num != 0) return false;
            tmp = num;
        }
        return true;
    }

    public void meveZeros1(int[] nums) {
        int n = nums.length;

        int numZeroes = 0;  // Count the zeroes
        List<Integer> list = new ArrayList<>(); // Make all the non-zero elements retain their original order.
        for (int num : nums) {
            if (num == 0) {
                numZeroes++;
            } else {
                list.add(num);
            }
        }

        for (int i = 0; i < numZeroes; i++) {
            list.add(0);
        }

        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int num: nums) {
            if(num != 0) nums[lastNonZeroFoundAt++] = num;
        }

        //After we have finished processing new elements,
        //all the non-zero elements are already at beginning of array.
        // we just need to fill remaining array with 0`s
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes3(int[] nums){
        int lastNonZeroFoundAt = 0;

        for (int num : nums) {
            if(num != 0){
                swap(nums[lastNonZeroFoundAt++], num);
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public void swap(int n1, int n2){
        int tmp = n1;
        n1 = n2;
        n2 = tmp;
    }
}
