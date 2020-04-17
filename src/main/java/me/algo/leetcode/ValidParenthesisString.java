package me.algo.leetcode;

public class ValidParenthesisString {
    public static void main(String[] args) {
//        String s = "(*))";
//        String s = ")(";
        String s = "(*)";
//        String s = "((*)";
//        String s = "(())";
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString(s));
    }

    /*
    ( -> min 0 max 1
    * -> min 0 max 2
    ) -> 0 1
     */
    //Greedy
    public boolean checkValidString(String s) {
        int maxLeftCnt = 0;
        int minLeftCnt = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') minLeftCnt++; else minLeftCnt--;
            if(c != ')') maxLeftCnt++; else maxLeftCnt--;
            if(maxLeftCnt <0) return false;
            minLeftCnt = Math.max(0, minLeftCnt);
        }
        return minLeftCnt == 0;
    }

    //DP
    /*
    public boolean checkValidString(String s) {
        int n = s.length();
        if (n == 0) return true;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') dp[i][i] = true;
            if (i < n-1 &&
                    (s.charAt(i) == '(' || s.charAt(i) == '*') &&
                    (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
                dp[i][i+1] = true;
            }
        }

        for (int size = 2; size < n; size++) {
            for (int i = 0; i + size < n; i++) {
                if (s.charAt(i) == '*' && dp[i+1][i+size] == true) {
                    dp[i][i+size] = true;
                } else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                    for (int k = i+1; k <= i+size; k++) {
                        if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
                                (k == i+1 || dp[i+1][k-1]) &&
                                (k == i+size || dp[k+1][i+size])) {
                            dp[i][i+size] = true;
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }
     */

    //BruteFore -- Time limit exceeded
    /*
    boolean ans = false;

    public boolean checkValidString(String s) {
        solve(new StringBuilder(s), 0);
        return ans;
    }

    public void solve(StringBuilder sb, int i) {
        if (i == sb.length()) {
            ans |= valid(sb);
        } else if (sb.charAt(i) == '*') {
            for (char c: "() ".toCharArray()) {
                sb.setCharAt(i, c);
                solve(sb, i+1);
                if (ans) return;
            }
            sb.setCharAt(i, '*');
        } else
            solve(sb, i + 1);
    }

    public boolean valid(StringBuilder sb) {
        int bal = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') bal++;
            if (c == ')') bal--;
            if (bal < 0) break;
        }
        return bal == 0;
    }
     */


}