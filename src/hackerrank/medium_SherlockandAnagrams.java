package hackerrank;

import java.util.Arrays;

public class medium_SherlockandAnagrams {

	public static void main(String[] args) {
		//String s = "abba";		//4
		//String s = "abcd";		//0
		//String s = "ifailuhkqq";		//3
		//String s = "kkkk";		//10
		String s = "cdcd";		//5
		
		System.out.println(sherlockAndAnagrams(s));
	}
	
	private static int sherlockAndAnagrams(String s) {
		int nRet = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String sTemp = s.substring(i, j);
				String[] arTemp = sTemp.split("");
				Arrays.sort(arTemp);
				sTemp = Arrays.toString(arTemp);
				
				for (int k = i + 1; k <= s.length(); k++) {
					if((k + j - i) > s.length()) {
						break;
					}
					String sTemp2 = s.substring(k, k + j - i);
					
					String[] arTemp2 = sTemp2.split("");
					Arrays.sort(arTemp2);
					sTemp2 = Arrays.toString(arTemp2);
					
					if(!sTemp.equals("[]") && sTemp.equals(sTemp2)) {
						nRet++;
					}
				}
			}
		}
		
		return nRet;
    }
	
	//CASE 2: 타임오버
	/*private static int sherlockAndAnagrams(String s) {
		int nRet = 0;
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String sTemp = s.substring(i, j);
				String[] arTemp = sTemp.split("");
				Arrays.sort(arTemp);
				sTemp = Arrays.toString(arTemp);
				
				for (int k = i + 1; k <= s.length(); k++) {
					if((k + j - i) > s.length()) {
						break;
					}
					String sTemp2 = s.substring(k, k + j - i);
					
					String[] arTemp2 = sTemp2.split("");
					Arrays.sort(arTemp2);
					sTemp2 = Arrays.toString(arTemp2);
					
					if(!sTemp.equals("[]") && sTemp.equals(sTemp2)) {
						nRet++;
					}
				}
			}
		}
		
		return nRet;
    }*/
	
	//CASE 1 : 풀이과정 진행중
	/*private static int sherlockAndAnagrams(String s) {
		int nRet = 0;
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String sTemp = s.substring(i, j);
				String[] arTemp = sTemp.split("");
				Arrays.sort(arTemp);
				sTemp = Arrays.toString(arTemp);
				
				System.out.println("S1 i : " + i + " j : " + j + " sTemp : " + sTemp);
				
				for (int k = i + 1; k <= s.length() - j; k++) {
					String sTemp2 = s.substring(k, k + j - i);
					System.out.println("S2 i : " + i + " j : " + j + " k : " + k + " sTemp : " + sTemp + " sTemp2 : " + sTemp2);
					
					String[] arTemp2 = sTemp2.split("");
					Arrays.sort(arTemp2);
					sTemp2 = Arrays.toString(arTemp2);
					
					if(!sTemp.equals("[]") && sTemp.equals(sTemp2)) {
						System.out.println("sTemp : " + sTemp);
						System.out.println("sTemp2 : " + sTemp2);
						nRet++;
					}
					
				}
				
				for (int k = i + 1; k <= s.length() - j; k++) {
					String sTemp2 = s.substring(k, k + j);
					
					System.out.println("sTemp : " + sTemp);
					System.out.println("sTemp2 : " + sTemp2);
					
					String[] arTemp2 = sTemp2.split("");
					Arrays.sort(arTemp2);
					sTemp2 = Arrays.toString(arTemp2);
					
					System.out.println("sTemp : " + sTemp);
					System.out.println("sTemp2 : " + sTemp2);
					
					if(!sTemp.equals("[]") && sTemp.equals(sTemp2)) {
						System.out.println("sTemp : " + sTemp);
						System.out.println("sTemp2 : " + sTemp2);
					}
				}
			}
		}
		
		
		return nRet;
    }*/
}
