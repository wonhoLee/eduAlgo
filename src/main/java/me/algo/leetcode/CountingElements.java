package me.algo.leetcode;

import java.util.HashMap;

public class CountingElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        CountingElements countingElements = new CountingElements();
        System.out.println(countingElements.countElements(arr));
    }

    public int countElements(int[] arr) {
        int ret = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for (int i : arr) {
            int target = i + 1;
            if (hashMap.containsKey(target)) {
                ret += 1;
            }
        }

        return ret;
    }

}
