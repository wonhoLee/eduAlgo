package me.algo.leetcode.recursion;

import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        int N = 4;
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib2(N));
    }

    public int fib(int N) {
        if (N < 2) {
            return N;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int fib2(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        int result = 0;
        if (N < 2) {
            result = N;
        } else {
            result = fib2(N - 1) + fib2(N - 2);
        }
        cache.put(N, result);
        return result;
    }
}
