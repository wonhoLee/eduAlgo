package programmers;

import java.util.regex.Pattern;

public class LV1_ceaserCryptograph {

	public static void main(String[] args) {
		/*String s = "AB";
		int n = 1;*/
		String s = "Z";
		int n = 1;
		/*String s = "a B z";
		int n = 4;*/
		
		System.out.println(solution(s, n));
	}

	//CASE2: 더나은식으로
	public static String solution(String s, int n) {
	    String answer = "";

	    for (int i = 0; i < s.length(); i++) {
	    	char cTemp = s.charAt(i);
	    	if(cTemp != ' ') {
	    		int nTemp = (int)cTemp;
	    		nTemp += n;
	    		if(Character.isUpperCase(cTemp)) {
	    			if(nTemp > 90) nTemp -= 26;
	    		}else if(Character.isLowerCase(cTemp)) {
	    			if(nTemp > 122) nTemp -= 26;
	    		}
	    		cTemp = (char)nTemp;
	    	}
	    	answer += cTemp;
		}
	    
	    return answer;
	}	
	
	//CASE1 : 풀이완료
	/*public static String solution(String s, int n) {
	    String answer = "";
	    String patternA = "^[A-Z]*$";
	    String patternB = "^[a-z]*$";

	    String[] arrTemp = s.split("");
	    
	    for (int i = 0; i < arrTemp.length; i++) {
	    	String sTemp = arrTemp[i];
	    	if(!sTemp.equals(" ")) {
	    		int nTemp = (int)sTemp.charAt(0);
	    		nTemp += n;
	    		if(Pattern.matches(patternA, sTemp)) {
	    			if(nTemp > 90) nTemp -= 26;
	    		}else if(Pattern.matches(patternB, sTemp)) {
	    			if(nTemp > 122) nTemp -= 26;
	    		}
	    		sTemp = String.valueOf((char)nTemp);
	    	}
	    	answer += sTemp;
		}
	    
	    return answer;
	}	*/
}
