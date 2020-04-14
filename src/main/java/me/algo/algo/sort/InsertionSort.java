package me.algo.algo.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.wonStudy(arr)));
    }

    public int[] solution(int[] arr) {
        if (arr == null) return null;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int k;
            for (k = i - 1; k >= 0; k--) {
                if (temp >= arr[k]) {
                    break;
                }
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = temp;
        }

        return arr;
    }

    /*
    9, 5, 7, 3, 2, 7, 3, 1, 10, 8
    9, 9
    5, 9 ,7
     */
    public int[] wonStudy(int[] arr) {
        if(arr == null) return null;

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i -1; j >= 0 ; j--) {
                if(tmp >= arr[j]) break;
                arr[j+1] = arr[j];
            }
            arr[j+1] = tmp;
        }

        return arr;
    }
}
