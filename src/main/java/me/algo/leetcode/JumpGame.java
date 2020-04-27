package me.algo.leetcode;

public class JumpGame {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {3,2,1,0,4};
        int[] nums = {2, 0, 0};
        JumpGame jumpGame = new JumpGame();

        System.out.println(jumpGame.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int lastGoodIndexPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastGoodIndexPosition){
                lastGoodIndexPosition = i;
            }
        }
        return lastGoodIndexPosition == 0;
    }
}
