package me.algo.leetcode;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int num = 2;
        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(num)));
    }

    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            arr[i] = arr[i >> 1] + (i & 1);
        }

        return arr;
    }

    public int[] countBits2(int num) {
        if (num < 0)
            return new int[1];

        // allocate array incuding 0->num
        int[] countBitArray = new int[num + 1];

        // initial DP data
        countBitArray[0] = 0;

        for (int i = 1; i <= num; i++) {
            // if num is even, bit count is same as num / 2
            // if odd, bit count is same as (num / 2) + 1
            countBitArray[i] = countBitArray[i >> 1] + i % 2;
        }

        return countBitArray;

    }
}
