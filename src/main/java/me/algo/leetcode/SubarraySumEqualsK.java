package me.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
//        int[] nums = {1,1,1}; int k = 2;
        int[] nums = {1,2,1,2,1}; int k = 3;
//        int[] nums = {1}; int k = 1;
//        int[] nums = {1, 2, 3}; int k = 3;
//        int[] nums = {28, 54, 7, -70, 22, 65, -6};    int k = 100;


        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(nums, k));
    }

//    public int subarraySum(int[] nums, int k) {
//        int answer = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            int sum = nums[i];
//            if(sum == k){
//                answer++;
//            }
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if(sum == k){
//                    answer++;
//                }
//            }
//        }
//        return answer;
//    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (cache.containsKey(sum - k)) {
                count += cache.get(sum - k);
            }
            cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        }
        System.out.println(cache);
        return count;
    }
}
