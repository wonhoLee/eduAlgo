package me.algo.algo.sort;

import static java.lang.Math.sqrt;

public class Prime {
    public boolean isPrime(int n){
        if(n <= 1) return false;
        if(n%2 == 0) return n == 2;
        for (int i = 3; i <=sqrt(n); i+=2) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
