package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		Q1_TwoSum question = new Q1_TwoSum();
		System.out.println(Arrays.toString(question.twoSum(nums, target)));
		
	}
	
//	public int[] twoSum(int[] nums, int target) {
//		int[] ret = new int[2];
//        for(int i = 0; i < nums.length ; i++){
//            for(int j = i; j < nums.length ; j++){
//                if(nums[i] + nums[j] == target){
//                    ret[0] = i;
//                    ret[1] = j;
//                    return ret;
//                }
//            }
//        }
//		return ret;
//    }
	
//	public int[] twoSum(int[] nums, int target) {
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			map.put(nums[i], i);
//		}
//		for (int i = 0; i < nums.length; i++) {
//			Integer nTemp = map.get(target - nums[i]);
//			if( nTemp != null && nTemp != i) {
//				return new int[] {i, nTemp};
//			}
//		}
//		throw new IllegalArgumentException("No Result");
//	}
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No Result");
	}
}
