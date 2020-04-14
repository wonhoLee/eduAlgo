package me.algo.algo.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.wonSolution(A, 0, A.length - 1)));
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

    public int[] wonSolution(int[] arr, int left, int right){
        if(arr == null) return null;
        int[] result = arr;
        if(left >= right) return result;

        int pivotPos = wonPartition(result, left, right);

        result = wonSolution(result, left, pivotPos - 1);
        result = wonSolution(result, pivotPos + 1, right);

        return  result;
    }

    private int wonPartition(int[] arr, int left, int right){
        if(arr == null || left < 0) return -1;
        int pivotValue = arr[right];
        int endOfLowBlock = left - 1;

        for (int i = left; i < right; ++i) {
            if(pivotValue > arr[i]){
                endOfLowBlock+=1;
                int tmp = arr[i];
                arr[i] = arr[endOfLowBlock];
                arr[endOfLowBlock] = tmp;
            }
        }
        endOfLowBlock += 1;
        int tmp = arr[right];
        arr[right] = arr[endOfLowBlock];
        arr[endOfLowBlock] = tmp;

        return endOfLowBlock;
    }
}
