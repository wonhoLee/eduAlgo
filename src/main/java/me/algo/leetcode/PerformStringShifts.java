package me.algo.leetcode;

public class PerformStringShifts {
    public static void main(String[] args) {
//        String s = "abc";
//        int[][] shift = {{0, 1}, {1, 2}};
        String s = "abcdefg";
        int[][] shift = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};

        PerformStringShifts performStringShifts = new PerformStringShifts();
        System.out.println(performStringShifts.stringShift(s, shift));
    }

    public String stringShift(String s, int[][] shift) {
        for (int[] detail:shift) {
            int direction = detail[0];
            int amount = detail[1];
            if(direction == 0){
                while(amount != 0){
                    s = s.substring(1, s.length()) + s.substring(0, 1);
                    amount--;
                }
            }else{
                while(amount != 0){
                    s = s.substring(s.length() -1, s.length()) + s.substring(0, s.length() -1);
                    amount--;
                }
            }
        }
        return s;
    }
}
