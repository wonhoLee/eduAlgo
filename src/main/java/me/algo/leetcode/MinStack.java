package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        //   --> Returns -3.
        minStack.pop();
        minStack.top();   //   --> Returns 0.
        System.out.println(minStack.getMin());
        //   --> Returns -2.
    }

    /**
     * initialize your data structure here.
     */
    List<Integer> list;
    int idx;

    public MinStack() {
        list = new ArrayList<>();
        idx = -1;
    }

    public void push(int x) {
        list.add(x);
        idx++;
    }

    public void pop() {
        if(list.isEmpty()) return;
        list.remove(idx);
        idx--;
    }

    public int top() {
        return list.get(idx);
    }

    public int getMin() {
        int tmp = Integer.MAX_VALUE;
        for (int n : list) {
            tmp = Math.min(tmp, n);
        }
        return tmp;
    }
}
