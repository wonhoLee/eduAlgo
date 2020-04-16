package me.algo.programmers.graph;

public class TargetNum {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        TargetNum targetNum = new TargetNum();
        System.out.println(targetNum.solution(numbers, target));
    }

//    public int solution(int[] numbers, int target) {
//        if(numbers == null) return 0;
//        dfs(0, numbers, -1, target);
//        return answer;
//    }
//    int answer = 0;
//    public void dfs(int sum, int[] numbers, int idx, int target){
//        if(idx >= numbers.length) return;
//        if(sum == target && idx == (numbers.length - 1)){
//            answer++;
//            return;
//        }
//
//        if(idx+1 < numbers.length){
//            dfs(sum + numbers[idx+1], numbers, idx+1, target);
//            dfs(sum - numbers[idx+1], numbers, idx+1, target);
//        }
//    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    public int dfs(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if(sum == target){
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum- numbers[n], target);
    }
}
