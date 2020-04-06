package me.algo.leetcode;

//https://kjwsx23.tistory.com/277
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums));

        System.out.println(maximumSubarray.dynamicProgramming(nums));
    }

//    public int maxSubArray(int[] nums){
//        if(nums == null || nums.length == 0) return 0;
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int nStart = 0;
//            for (int j = i; j < nums.length; j++) {
//                nStart += nums[j];
//                max = Math.max(max, nStart);
//            }
//        }
//
//        return max;
//    }

    public int maxSubArray(int[] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }

    public int divideConquer(int[] nums, int s, int e) {
        //base case
        if (s == e) return nums[s];

        int m = (s + e) / 2;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int sum = 0;

        //중간에 걸친 경우, 왼쪽 최대합을 구한다.
        for (int i = m; i >= s; i--) {
            sum += nums[i];
            left = Math.max(left, sum);
        }

        //중간에 걸친 경우, 오른쪽 최대합을 구한다.
        sum = 0;
        for (int i = m + 1; i <= e; i++) {
            sum += nums[i];
            right = Math.max(right, sum);
        }

        //걸치지 않고 양분된 구간 내에 속하는 경우
        int single = Math.max(divideConquer(nums, s, m), divideConquer(nums, m + 1, e));

        //중간에 걸친 경우와 걸치지 않은 경우 중 높은 값을 반환한다.
        return Math.max(left + right, single);
    }

    public int dynamicProgramming(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int partialSum = 0;

        for (int i = 0; i < n; i++) {
            partialSum = Math.max(0, partialSum) + arr[i];
            max = Math.max(partialSum, max);
        }

        return max;
    }
}
