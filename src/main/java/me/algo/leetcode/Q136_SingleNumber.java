package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Q136_SingleNumber {
//    public int singleNumber(int[] nums) {
//        int ret = 0;
//        HashMap<Integer, Integer> maps = new HashMap<>();
//        
//        for (int i = 0; i < nums.length; i++) {
//        	maps.put(nums[i], maps.getOrDefault(nums[i], 0) + 1);
//		}
//        
//        for (int i = 0; i < nums.length; i++) {
//        	if(maps.get(nums[i]) == 1) {
//        		ret = nums[i];
//        	}
//		}
//        
//        return ret;
//    }
	
//	public int singleNumber(int[] nums) {
//        int ret = 0;
//        
//        for (int num: nums) {
//        	ret^=num;
//		}
//        
//        return ret;
//    }
	
	public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (x, y) -> x ^ y);
    }
    
    public static void main(String[] args) {
		Q136_SingleNumber algoTest = new Q136_SingleNumber();
		//int[] nums = {2,2,1};
		int[] nums = {4,1,2,1,2};
		System.out.println(algoTest.singleNumber(nums));
	}
}