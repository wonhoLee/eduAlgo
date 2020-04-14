package me.algo.algo.sort;

import me.algo.leetcode.SearchBST;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 9, 5, 7, 3, 2, 7, 3, 1, 10, 8 };

        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.case1(arr)));
    }

    public int[] case1(int[] arr){
        if(arr == null) return null;
        int[] result = arr;
        int maxPos;

        for (int i = 0; i < result.length -1; i++) {
            maxPos = i;
            for (int j = i + 1; j < result.length; j++) {
                if(result[maxPos] > result[j]){
                    maxPos = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[maxPos];
            arr[maxPos] = tmp;
        }

        return arr;
    }
}
