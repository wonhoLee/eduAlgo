package hackerrank;

public class easy_TwoStrings {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";	//YES
		//String s1 = "hi";
		//String s2 = "world";	//NO
		System.out.println(twoStrings(s1, s2));
	}

	private static String twoStrings(String s1, String s2) {
		String sRet = "NO";
		String[] sTemp2 = "abcdefrhijklmnopqrxtuvwxyz".split("");
		for (int i = 0; i < sTemp2.length; i++) {
			if(s1.indexOf(sTemp2[i]) != -1 && s2.indexOf(sTemp2[i]) != -1){
				sRet = "YES";
				break;
			}
		}
		return sRet;
    }
	
	//CASE1 : 시간실패
	/*private static String twoStrings(String s1, String s2) {
		String sRet = "NO";
		String[] sTemp2 = s2.split("");
		for (int i = 0; i < sTemp2.length; i++) {
			if(s1.indexOf(sTemp2[i]) != -1){
				sRet = "YES";
				break;
			}
		}
		return sRet;
    }*/
	
	//CASE2 : 시간실패
	/*private static String twoStrings(String s1, String s2) {
		boolean bFlag;
		
		if(s1.length() > s2.length()) {
			bFlag = find(s1, s2);
		}else {
			bFlag = find(s2, s1);
		}
		
		return (bFlag)?"YES":"NO";
    }
	
	private static boolean find(String s1, String s2) {
		boolean bFlag = false;
		String[] sTemp2 = s2.split("");
		for (int i = 0; i < sTemp2.length; i++) {
			if(s1.indexOf(sTemp2[i]) != -1){
				bFlag = true;
				break;
			}
		}
		
		return bFlag;
	}*/
}
