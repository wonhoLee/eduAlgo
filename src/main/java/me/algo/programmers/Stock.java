package me.algo.programmers;

import java.util.Arrays;
import java.util.Stack;

public class Stock {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        Stock stock = new Stock();
        System.out.println(Arrays.toString(stock.solution(prices)));
    }

    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            int nCnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                nCnt ++;
                if(cur > prices[j]){
                    break;
                }
            }
            answer[i] = nCnt;
        }

        return answer;
    }
}
