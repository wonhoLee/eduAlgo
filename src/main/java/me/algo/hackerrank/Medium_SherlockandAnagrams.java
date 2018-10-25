package me.algo.hackerrank;

import java.util.Arrays;

public class Medium_SherlockandAnagrams {

	public static void main(String[] args) {
		String s = "abba";		//4
		//String s = "abcd";		//0
		//String s = "ifailuhkqq";		//3
		//String s = "kkkk";		//10
		//String s = "cdcd";		//5
		
		System.out.println(sherlockAndAnagrams(s));
	}
	
	private static int sherlockAndAnagrams(String s) {
		int nRet = 0;
		
		for (int i = 0; i < s.length(); i++) {//��ġ����
			for (int j = i + 1; j < s.length(); j++) {	//ǥ������
				String sTemp = s.substring(i, j);
				
				for (int k = i + 1; k <= s.length(); k++) {	//�񱳴�����
					if((k + j - i) > s.length()) {
						break;
					}
					String sTemp2 = s.substring(k, k + j - i);
					
					if(check_anagram(sTemp, sTemp2)==1)
						nRet++;
				}
			}
		}
		
		return nRet;
    }
	
	//RESULT : ����
	/*private static int sherlockAndAnagrams(String s) {
		int nRet = 0;
		char[] sa;
        sa = s.toCharArray();
        
		for(int index=1; index < sa.length; index++){
            for(int i=0;i<sa.length-index+1;i++){
                String s1 = s.substring(i,index+i);
               for(int j=i+1;j<sa.length-index+1;j++){
                   String s2 = s.substring(j,index+j);
                   if(check_anagram(s1,s2)==1)
                       nRet++;
                }
            }
        }

		return nRet;
    }*/
	
	public static int check_anagram(String s1, String s2)
    {
        char a[] = s1.toCharArray();
        char b[] = s2.toCharArray();
        //System.out.println(s1+" "+s2);
       int first[] = new int[26];
        int second[] = new int[26];
        Arrays.fill(first,0);
        Arrays.fill(second,0);
        int c=0;
       while (c<a.length) {
          first[a[c]-'a']++;
          c++;
       }
       c = 0;
       while (c<b.length) {
          second[b[c]-'a']++;
          c++;
       }

       for (c = 0; c < 26; c++) {
          if (first[c] != second[c])
             return 0;
       }

       return 1;
    }
	
	//CASE 2: Ÿ�ӿ���
	/*private static int sherlockAndAnagrams(String s) {
		int nRet = 0;
		
		for (int i = 0; i < s.length(); i++) {//��ġ����
			for (int j = i + 1; j < s.length(); j++) {	//ǥ������
				String sTemp = s.substring(i, j);
				String[] arTemp = sTemp.split("");
				Arrays.sort(arTemp);
				sTemp = Arrays.toString(arTemp);
				
				for (int k = i + 1; k <= s.length(); k++) {	//�񱳴�����
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
	
	//CASE 1 : Ǯ�̰��� ������
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
