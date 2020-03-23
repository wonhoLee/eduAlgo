package me.algo.programmers.kakao2020;

//https://programmers.co.kr/learn/courses/30/lessons/60057
public class Q1_string_compress {
    public static void main(String[] args) {
        String ex1 = "aabbaccc";
        Q1_string_compress q1_string_compress = new Q1_string_compress();
        System.out.println(q1_string_compress.solution(ex1));
    }

    public int solution(String s) {
        int answer = 0;

        int nEnd = s.length() / 2 + 1;
        answer = case1(s, 1).length();
        for (int i = 2; i < nEnd; i++) {
            String value = case1(s, i);
            int nTmp = value.length();
            if (answer > nTmp) {
                answer = nTmp;
            }
        }

        return answer;
    }

    private String case1(String inputTxt, int nInput) {
        String resultTxt = "";
        int count = 1;

        String charTmp = inputTxt.substring(0, nInput);
        for (int i = nInput; i <= inputTxt.length() - nInput; i = i + nInput) {
            if (!inputTxt.substring(i, i + nInput).equals(charTmp)) {
                resultTxt += setResult(count, charTmp);
                count = 1;

                charTmp = inputTxt.substring(i, i + nInput);
            } else {
                count++;
            }
        }
        resultTxt += setResult(count, charTmp);

        int nTemp = inputTxt.length() % nInput;
        if (nTemp != 0) {
            resultTxt += inputTxt.substring(inputTxt.length() - nTemp, inputTxt.length());
        }

        return resultTxt;
    }

    private String setResult(int count, String input) {
        if (count == 1) {
            return input;
        } else {
            return count + "" + input;
        }
    }
}
