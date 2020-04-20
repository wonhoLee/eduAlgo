package me.algo.programmers;

public class NumBaseball {
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        NumBaseball numBaseball = new NumBaseball();
        System.out.println(numBaseball.solution2(baseball));
    }

    public int solution(int[][] baseball) {
        int answer = 0;

        for (int i = 123; i <= 987; i++) {
            String tmp = String.valueOf(i);
            Boolean flag = true;
            if (tmp.charAt(0) == tmp.charAt(1) || tmp.charAt(1) == tmp.charAt(2) || tmp.charAt(0) == tmp.charAt(2))
                continue;
            if (tmp.charAt(0) == '0' || tmp.charAt(1) == '0' || tmp.charAt(2) == '0') continue;

            for (int j = 0; j < baseball.length; j++) {
                int strike = 0;
                int ball = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        String num = String.valueOf(baseball[j][0]);
                        boolean b = tmp.charAt(k) == num.charAt(l);
                        if (k == l && b) {
                            strike++;
                            continue;
                        } else if (b) {
                            ball++;
                            continue;
                        }
                    }
                }
                if (strike != baseball[j][1] || ball != baseball[j][2]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }

    public int solution2(int[][] baseball) {
        int answer = 0;

        for (int i = 123; i <= 987; i++) {
            String temp = String.valueOf(i);
            Boolean flag = true;
            if (temp.charAt(0) == temp.charAt(1) || temp.charAt(1) == temp.charAt(2) || temp.charAt(0) == temp.charAt(2))
                continue;
            if (temp.charAt(0) == '0' || temp.charAt(1) == '0' || temp.charAt(2) == '0') continue;
            for (int j = 0; j < baseball.length; j++) {
                String score = String.valueOf(baseball[j][0]);
                int strike = 0;
                int ball = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (k == l && temp.charAt(k) == score.charAt(l)) {
                            strike++;
                            continue;
                        } else if (temp.charAt(k) == score.charAt(l)) {
                            ball++;
                            continue;
                        }
                    }
                }
                if (strike != baseball[j][1] || ball != baseball[j][2]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }

        return answer;
    }
}
