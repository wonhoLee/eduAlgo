package me.algo.leetcode;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        System.out.println(singleElementInASortedArray.singleNonDuplicate(nums));
    }

    //    public int singleNonDuplicate(int[] nums) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int n : nums) {
//            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
//        }
//
//        for (Integer key : hashMap.keySet()) {
//            if (hashMap.get(key) == 1) return key;
//        }
//        return 0;
//    }
    public int singleNonDuplicate(int[] nums) {
        int answer = 0;

        for (int n : nums) {
            answer = answer ^ n;
        }

        return answer;
    }
}
