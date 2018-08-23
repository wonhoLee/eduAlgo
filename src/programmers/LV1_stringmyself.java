package programmers;

import java.util.Arrays;

public class LV1_stringmyself {

	public static void main(String[] args) {
		//String[] strings = {"sun", "bed", "car"};
		//int n = 1;
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		
		System.out.println(Arrays.toString(solution(strings, n)));
	}

	public static String[] solution(String[] strings, int n) {
	    String temp = "";
	    Arrays.sort(strings);
	    for(int i = 0; i < strings.length; i++) {
			for(int j= 1 ; j < strings.length-i; j++) {
				if(strings[j].charAt(n) < strings[j-1].charAt(n)) {
					temp = strings[j-1];
					strings[j-1] = strings[j];
					strings[j] = temp;
				}
			}
		}
	    
	    return strings;
	}
}
