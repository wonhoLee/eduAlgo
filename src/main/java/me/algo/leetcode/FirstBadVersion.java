package me.algo.leetcode;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 5;
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(n));
    }

    public int firstBadVersion(int n) {
        return recursion(1, n);
    }

    public int recursion(int start, int end) {
        if (start >= end) return start;
        int m = start + (end - start) / 2;

        if (isBadVersion(m)) {
            return recursion(start, m);
        } else {
            return recursion(m + 1, end);
        }
    }

    boolean isBadVersion(int version) {
        if (version == 3) {
            return false;
        } else if (version == 4) {
            return true;
        } else return version == 5;
    }
}
