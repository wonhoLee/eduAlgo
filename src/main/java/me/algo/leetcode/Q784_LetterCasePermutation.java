package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q784_LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        char[] arrChar = S.toCharArray();
        permutation(arrChar, ret, 0);
        return ret;
    }
    
    public void permutation(char[] arrChar, List<String> ret, int index) {
    	if(arrChar.length == index) {
    		ret.add(new String(arrChar));
    	}else {
    		char c = arrChar[index];
        	if(Character.isDigit(c)) {
        		permutation(arrChar, ret, index+1);
        	}else {
        		arrChar[index] = Character.toLowerCase(c);
        		permutation(arrChar, ret, index+1);
        		arrChar[index] = Character.toUpperCase(c);
        		permutation(arrChar, ret, index+1);
        	}
    	}
    }
    
    public static void main(String[] args) {
    	Q784_LetterCasePermutation sample = new Q784_LetterCasePermutation();
    	String S = "a1b2";
    	System.out.println(sample.letterCasePermutation(S));
	}
}
