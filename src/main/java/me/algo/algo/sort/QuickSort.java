package me.algo.algo.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
        QuickSort quickSort = new QuickSort();
//        System.out.println(Arrays.toString(quickSort.soulution(A, 0, A.length - 1)));
        quickSort.wonquick(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    public int[] soulution(int[] arr, int left, int right){
        if(arr == null) return null;
        int[] result = arr;
        if (left >= right) return result;

        int pivotPos = partition(result, left, right);

        result = soulution(result, left, pivotPos - 1);
        result = soulution(result, pivotPos + 1, right);

        return result;
    }

    private int partition(int[] arr, int left, int right){
        if(arr == null || left < 0 ) return -1;
        int pivotValue = arr[right];
        int endOfLowBlock = left - 1;

        for (int pos = left; pos < right; ++pos) {
            if(pivotValue > arr[pos]){
                endOfLowBlock += 1;
                int tmp = arr[pos];
                arr[pos] = arr[endOfLowBlock];
                arr[endOfLowBlock] = tmp;
            }
        }
        endOfLowBlock += 1;
        int tmp = arr[right];
        arr[right] = arr[endOfLowBlock];
        arr[endOfLowBlock] = tmp;

        return endOfLowBlock;
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int key = start;
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (i <= end && arr[i] <= arr[key]) { // 키 값보다 큰 값
                i++;
            }
            while (j > start && arr[j] >= arr[key]) {    // 키값보다 작은 값
                j--;
            }
            if (i > j) {      // 엇갈린 상태면 키 값과 교체
                int temp = arr[j];
                arr[j] = arr[key];
                arr[key] = temp;
            } else {          // 엇갈리지 않았다면 i 와 j를 교체
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }

    public void wonquick(int[] arr, int start, int end) {
        if (start >= end) return;
        int key = start;
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= end && arr[i] <= arr[key]) {
                i++;
            }
            while (j > start && arr[j] >= arr[key]) {
                j--;
            }
            if (i > j) {
                int tmp = arr[j];
                arr[j] = arr[key];
                arr[key] = tmp;
            } else {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        wonquick(arr, start, j - 1);
        wonquick(arr, j + 1, end);
    }
}
