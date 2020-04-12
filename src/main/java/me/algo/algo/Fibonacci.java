package me.algo.algo;

import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {

    }

    public int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    HashMap<Integer, Integer> cache = new HashMap<>();

    private int fib(int N) {
        if (cache.containsKey(N)) return cache.get(N);
        int result;
        if (N < 2) {
            result = N;
        } else {
            result = fib(N - 1) + fib(N - 2);
        }
        cache.put(N, result);
        return result;
    }
}
