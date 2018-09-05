package programmers;

public class LV2_JadenCase {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		String answer = "";
		
		String[] arrTemp = s.toLowerCase().split("");
		
		answer = arrTemp[0].toUpperCase();
		for (int i = 1; i < arrTemp.length; i++) {
			String sTemp = arrTemp[i];
			if(arrTemp[i-1].equals(" ")) {
				sTemp = sTemp.toUpperCase();
			}
			answer += sTemp;
		}
		
	    return answer;
	}
}
