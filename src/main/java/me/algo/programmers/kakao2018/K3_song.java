package me.algo.programmers.kakao2018;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class K3_song {
    public static void main(String[] args) {
//        String m = "ABCDEFG"; String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
//        String m = "ABC"; String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        K3_song k3_song = new K3_song();
        System.out.println(k3_song.solution(m, musicinfos));
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "`(None)`";
        long answerTimeSize = 0;

        String mTarget = m.replaceAll("C#", "H")
                .replaceAll("D#", "I")
                .replaceAll("F#", "J")
                .replaceAll("G#", "K")
                .replaceAll("A#", "L");

        for (String music : musicinfos) {
            String[] detail = music.split(",");
            LocalDateTime startTime = LocalDateTime.parse("2020-04-30 " + detail[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            LocalDateTime endTime = LocalDateTime.parse("2020-04-30 " + detail[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            long timeSize = ChronoUnit.MINUTES.between(startTime, endTime);

            String temp = detail[3]
                    .replaceAll("C#", "H")
                    .replaceAll("D#", "I")
                    .replaceAll("F#", "J")
                    .replaceAll("G#", "K")
                    .replaceAll("A#", "L");

            List<String> meList = new ArrayList<>();

            int idx = 0;
            long calc = timeSize;
            int size = temp.length();
            while (calc != 0) {
                if (idx == size) {
                    idx -= size;
                }
                meList.add(String.valueOf(temp.charAt(idx)));

                idx++;
                calc--;
            }

            String target = String.join("", meList);

            if (target.contains(mTarget)) {
                if (answerTimeSize < timeSize) {
                    answer = detail[2];
                    answerTimeSize = timeSize;
                }
            }
        }
        return answer;
    }
//    public String solution(String m, String[] musicinfos) {
//        String answer = "`(None)`";
//        long answerTimeSize = 0;
//        for (String music : musicinfos) {
//            String[] detail = music.split(",");
//            LocalDateTime startTime = LocalDateTime.parse("2020-04-30 " + detail[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//            LocalDateTime endTime = LocalDateTime.parse("2020-04-30 " + detail[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//            long timeSize = ChronoUnit.MINUTES.between(startTime, endTime);
//
//            String temp = detail[3]
//                    .replaceAll("C#", "H")
//                    .replaceAll("C#", "I")
//                    .replaceAll("C#", "J")
//                    .replaceAll("C#", "K")
//                    .replaceAll("C#", "L");
//
//            List<String> list = new ArrayList<>();
//            for (int i = 0; i < detail[3].length(); i++) {
//                String ch = String.valueOf(detail[3].charAt(i));
//                if (ch.equals("#")) {
//                    String temp = list.get(list.size() - 1) + ch;
//                    list.remove(list.size() - 1);
//                    list.add(temp);
//                } else {
//                    list.add(ch);
//                }
//            }
//
//            List<String> meList = new ArrayList<>();
//
//            int idx = 0;
//            long calc = timeSize;
//            while (calc != 0) {
//                if (idx == list.size()) {
//                    idx -= list.size();
//                }
//                meList.add(list.get(idx));
//
//                idx++;
//                calc--;
//            }
//
//            String target = meList.stream().collect(Collectors.joining());
//            System.out.println(target);
//
//
//
//            if (target.contains(m)) {
//                if (answerTimeSize < timeSize) {
//                    answer = detail[2];
//                    answerTimeSize = timeSize;
//                }
//            }
//        }
//        return answer;
//    }

}
