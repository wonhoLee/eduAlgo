package me.algo.algo.dp;

//https://www.youtube.com/watch?v=EKHFu9vB-Oc
public class ClimbingStairs {
    public static void main(String[] args) {
//        int[] stairs = {10, 15, 20};
        int[] stairs = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.solution(stairs));
    }

    public int solution(int[] stairs) {
        int case1 = 0;
        int case2 = 0;
        int current;
        for (int i = stairs.length - 1; i >= 0; --i) {
            current = stairs[i] + Math.min(case1, case2);
            case2 = case1;
            case1 = current;
        }
        return Math.min(case1, case2);
    }
}
