package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {
    public static void main(String[] args) {
        OnlineStockSpan onlineStockSpan = new OnlineStockSpan();
        System.out.println(onlineStockSpan.next(100));
        System.out.println(onlineStockSpan.next(80));
        System.out.println(onlineStockSpan.next(60));
        System.out.println(onlineStockSpan.next(70));
        System.out.println(onlineStockSpan.next(60));
        System.out.println(onlineStockSpan.next(75));
        System.out.println(onlineStockSpan.next(85));
        //1112146
//        System.out.println(onlineStockSpan.next(29));
//        System.out.println(onlineStockSpan.next(91));
//        System.out.println(onlineStockSpan.next(62));
//        System.out.println(onlineStockSpan.next(76));
//        System.out.println(onlineStockSpan.next(51));
        //12121
    }


    static class Stock{
        int val;
        int cnt;

        public Stock(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        public int getVal() {
            return val;
        }

        public int getCnt() {
            return cnt;
        }
    }
    Stack<Stock> stack;
    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int cnt = 1;
        while(!stack.isEmpty() && price >= stack.peek().getVal()){
            cnt += stack.pop().getCnt();
        }
        stack.push(new Stock(price, cnt));

        return cnt;
    }
}
