package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/majority-element/submissions/
public class Q169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        Q169 q169 = new Q169();
        System.out.println(q169.majorityElement2(nums));
    }

    public int majorityElement(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int n = nums.length / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (Integer key : hashMap.keySet()) {
            Integer value = hashMap.get(key);
            if (value > n) {
                if (ret < key) ret = key;
            }
        }

        return ret;
    }

    //https://leetcode.com/problems/majority-element/submissions/
    public int majorityElement2(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int cnt = 0;

        for(int num : nums){
            if(cnt == 0) {
                ret = num;
                cnt++;
            }
            else if(ret == num) cnt++;
            else cnt--;
        }

        return ret;
    }
}
