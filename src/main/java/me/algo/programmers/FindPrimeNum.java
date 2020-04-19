package me.algo.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class FindPrimeNum {
    public static void main(String[] args) {
//        String numbers = "17";
        String numbers = "011";

        FindPrimeNum findPrimeNum = new FindPrimeNum();
        System.out.println(findPrimeNum.solution(numbers));
    }

    public int solution(String numbers) {
        List<Integer> ret = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        boolean[] visited = new boolean[numbers.length()];
        for (int i = 1; i <= numbers.length(); i++) {
            backtrack(numbers, ret, tmp, visited, i);
        }
//        System.out.println(ret);
        return ret.size();
    }

    public void backtrack(String numbers, List<Integer> ret, List<String> tmp, boolean[] visited, int end) {
        //base case
        if (tmp.size() == end) {
            String target = tmp.stream().collect(Collectors.joining("")).toString();
            int nTarget = Integer.parseInt(target);

            if (!ret.contains(nTarget)) {
                if (isPrime(nTarget)) {
                    ret.add(nTarget);
                }
            }

            return;
        }

        String[] numberArr = numbers.split("");
        //recursion
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            tmp.add(numberArr[i]);
            backtrack(numbers, ret, tmp, visited, end);
            tmp.remove(numberArr[i]);
            visited[i] = false;
        }
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n % 2 == 0) return n == 2 ? true : false;
        for (int i = 3; i <= sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
