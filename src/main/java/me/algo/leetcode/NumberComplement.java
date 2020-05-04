package me.algo.leetcode;

public class NumberComplement {
    public static void main(String[] args) {
        int num = 5;
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(num));
    }

    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if (c == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
