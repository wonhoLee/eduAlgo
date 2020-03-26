package me.algo.leetcode;

import java.util.Arrays;

//https://www.youtube.com/watch?v=mbOl9qPedDo
public class Q31_NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1,4,5,4,3};
        Q31_NextPermutation q31_nextPermutation = new Q31_NextPermutation();
        q31_nextPermutation.nextPermutation(nums);
    }

    /*
    1 4(a) 5 4 3(b)
    ->
    1 4 3 4 5
     */
    public void nextPermutation(int[] nums) {
        //뒤에서부터 탐색하면서 오름차순이 깨지는 인덱스를 확인(a)
        int a = nums.length - 2;
        while (a >= 0 && nums[a] >= nums[a + 1]) a--;
        if (a != -1) {
            // 다시 뒤에서부터 탐색하면서 a보다 큰 첫번때 인덱스를 확인(b)
            int b = nums.length - 1;
            while (nums[a] >= nums[b]) b--;
            //a랑 b를 스왑
            swap(nums, a, b);
        }
        //a+1에서부터 끝까지를 오름차순 정렬
        int start = a + 1;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
