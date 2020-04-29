package me.algo.programmers.kakao2018;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class K1_ShuttleBus {
    public static void main(String[] args) {
//        int n = 1; int t = 1; int m = 5; String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
//        int n = 2; int t = 10; int m = 2; String[] timetable = {"09:10", "09:09", "08:00"};
        int n = 2;
        int t = 1;
        int m = 2;
        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
//        int n = 1; int t = 1; int m = 1; String[] timetable = {"23:59"};

        K1_ShuttleBus k1ShuttleBus = new K1_ShuttleBus();
        System.out.println(k1ShuttleBus.solution(n, t, m, timetable));
    }

    /*
    크루수가 정해져 있음

    마지막 버스기준 탑승인원에 따라 결정?
    마지막 버스기준에 탑승인원으로 대상자 간추리기
    m > crew -> 버스시간
    m <= crew -> 마지막도착인원 - 1분
     */
    public String solution(int n, int t, int m, String[] timetable) {
        String answer;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse("2020-04-29 09:00", dateTimeFormatter);
        Queue<String> q = new LinkedList<>();
        Arrays.sort(timetable);
        for (String time : timetable) {
            q.offer(time);
        }

        while (n > 1) {
            int maxCrew = m;
            //비교
            while (!q.isEmpty()) {
                if (maxCrew == 0) break;
                String time = q.peek();
                LocalDateTime tempTime = LocalDateTime.parse("2020-04-29 " + time, dateTimeFormatter);
                if (ChronoUnit.MINUTES.between(tempTime, localDateTime) >= 0) {
                    maxCrew--;
                    q.poll();
                } else {
                    break;
                }
            }

            localDateTime = localDateTime.plusMinutes(t);
            n--;
        }

        List<String> list = new ArrayList<>();
        while (!q.isEmpty()) {
            String time = q.poll();
            LocalDateTime tempTime = LocalDateTime.parse("2020-04-29 " + time, dateTimeFormatter);
            if (ChronoUnit.MINUTES.between(tempTime, localDateTime) >= 0) {
                list.add(time);
            }
        }

        if (list.size() >= m) {
            LocalDateTime tempTime = LocalDateTime.parse("2020-04-29 " + list.get(m - 1), dateTimeFormatter).minusMinutes(1);
            answer = tempTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        } else {
            answer = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        }

        return answer;
    }
}
