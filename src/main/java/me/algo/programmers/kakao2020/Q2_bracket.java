package me.algo.programmers.kakao2020;

//https://programmers.co.kr/learn/courses/30/lessons/60058
public class Q2_bracket {
    public static void main(String[] args) {
        String ex1 = "(()())()";
        Q2_bracket q2_bracket = new Q2_bracket();
        System.out.println(q2_bracket.solution(ex1));
    }

    public String solution(String p) {
        String answer = "";

        //1
        if (p.isBlank() || p.isEmpty()) return p;

        //2
        int nGubun = case2(p);
        String u = p.substring(0, nGubun + 1);
        String v = p.substring(nGubun + 1, p.length());

        //3
        if (case3(u)) {
            //3-1
            return u + solution(v);
        }

        //4
        answer = "(";
        answer += solution(v);
        answer += ")";

        String uValue = u.substring(1, u.length() - 1);
        for (int i = 0; i < uValue.length(); i++) {
            if (uValue.charAt(i) == '(') {
                answer += ")";
            } else {
                answer += "(";
            }
        }

        return answer;
    }

    public int case2(String p) {
        int leftCnt = 0;
        int rightCnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                leftCnt++;
            } else {
                rightCnt++;
            }
            if (leftCnt == rightCnt) {
                return i;
            }
        }

        return p.length();
    }

    public boolean case3(String p) {
        int nCnt = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                nCnt++;
            } else {
                nCnt--;
            }
            if (nCnt < 0) {
                return false;
            }
        }

        return true;
    }
}
