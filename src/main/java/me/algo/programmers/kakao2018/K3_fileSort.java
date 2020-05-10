package me.algo.programmers.kakao2018;

import java.util.Arrays;

//https://javaplant.tistory.com/12
public class K3_fileSort {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        K3_fileSort k3_fileSort = new K3_fileSort();
        System.out.println(Arrays.toString(k3_fileSort.solution(files)));
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            // 첫번째 오브젝트 head, num 추출
            String head1 = s1.split("[0-9]")[0];
            s1 = s1.replace(head1, "");
            head1 = head1.toUpperCase();

            String tempNum = "";
            for (char c : s1.toCharArray()) {
                if (Character.isDigit(c) && tempNum.length() < 5) {
                    tempNum += c;
                } else {
                    break;
                }
            }
            int num1 = Integer.parseInt(tempNum);

            // 두번째 오브젝트 head, num 추출
            String head2 = s2.split("[0-9]")[0];
            s2 = s2.replace(head2, "");
            head2 = head2.toUpperCase();

            tempNum = "";
            for (char c : s2.toCharArray()) {
                if (Character.isDigit(c) && tempNum.length() < 5) {
                    tempNum += c;
                } else {
                    break;
                }
            }
            int num2 = Integer.parseInt(tempNum);

            // 비교 처리
            return head1.equals(head2) ? num1 - num2 : head1.compareTo(head2);
        });

        return files;
    }

    public String[] soulution2(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            String x1 = s1.split("[0-9]")[0];
            s1 = s1.replace(x1, "");
            x1 = x1.toUpperCase();
            String tmp = "";
            for (char c : s1.toCharArray()) {
                if (Character.isDigit(c)) {
                    tmp += c;
                } else {
                    break;
                }
            }
            int n1 = Integer.parseInt(tmp);

            String x2 = s2.split("[0-9]")[0];
            s2 = s2.replace(x2, "");
            x2 = x2.toUpperCase();
            tmp = "0";
            for (char c : s2.toCharArray()) {
                if (Character.isDigit(c)) {
                    tmp += c;
                } else {
                    break;
                }
            }
            int n2 = Integer.parseInt(tmp);


            return x1.equals(x2) ? n1 - n2 : x1.compareTo(x2);
        });

        return files;
    }
}
