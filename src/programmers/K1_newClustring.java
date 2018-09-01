package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class K1_newClustring {

	public static void main(String[] args) {
		/*String str1 = "FRANCE";
		String str2 = "french";	//16384 */
		/*String str1 = "handshake";
		String str2 = "shake hands";*/	//65536
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";		//43690
		/*String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";*/		//65536
		System.out.println(solution(str1, str2));
	}
	
	public static int solution(String str1, String str2) {
		int nInter = 0;
		int nUnion = 0;
		Set<String> setTarget = new HashSet<>();
		
		List<String> listStr1 = getPattern(str1);
		List<String> listStr2 = getPattern(str2);
		Collections.sort(listStr1, new Comparator<String>(){
			public int compare(String obj1, String obj2)
		    {
				return obj1.compareTo(obj2);
		    }
		});
		Collections.sort(listStr2, new Comparator<String>(){
			public int compare(String obj1, String obj2)
		    {
				return obj1.compareTo(obj2);
		    }
		});
			
		setTarget.addAll(listStr1);
		setTarget.addAll(listStr2);
		
		List<String> listTarget = new ArrayList<>(setTarget);
		
		for (int i = 0; i < listTarget.size(); i++) {
			String sTemp = listTarget.get(i);
			int str1Hit = 0;
			int str2Hit = 0;
			if(listStr1.contains(sTemp)) {
				for (int j = 0; j < listStr1.size(); j++) {
					if(sTemp.equals(listStr1.get(j))) {
						str1Hit++;
					}
				}
			}
			if(listStr2.contains(sTemp)) {
				for (int j = 0; j < listStr2.size(); j++) {
					if(sTemp.equals(listStr2.get(j))) {
						str2Hit++;
					}
				}
			}
			
			int nTemp = Math.min(str1Hit, str2Hit);
			if(nTemp > 0) {
				for (int j = 0; j < nTemp; j++) {
					nInter++;
				}
			}
			
			nTemp = Math.max(str1Hit, str2Hit);
			if(nTemp > 0) {
				for (int j = 0; j < nTemp; j++) {
					nUnion++;
				}
			}
		}
		
		double nTemp;
		if(nUnion == 0 && nInter == 0) {
			nTemp = 1;
		}else{
			nTemp = (double)nInter / nUnion;
		}
	    return (int) Math.floor(nTemp * 65536);
	}
	
	private static List<String> getPattern(String sInput){
		String pattern = "^[a-zA-Z]*$";
		
		List<String> lRet = new ArrayList<>();
		for (int i = 0; i < sInput.length() - 1; i++) {
			String sTemp;
			sTemp = sInput.substring(i, i+2).toUpperCase();
			
			if(Pattern.matches(pattern, sTemp)) {
				lRet.add(sTemp);
			}
		}
		
		return lRet;
	}
	
	//CASE1 : 오답 -> 다중집합 이해를 제대로 못함
	/*public static int solution(String str1, String str2) {
		List<String> lTemp1 = getPattern(str1, true);
		List<String> lTemp2 = getPattern(str2, true);
		List<String> lTempUnion = new ArrayList<>();
		
		int nInter = 0;
		int nUnion = 0;
		
		if(lTemp1.size() > lTemp2.size()) {
			lTempUnion.addAll(lTemp1);
		}else {
			lTempUnion.addAll(lTemp2);
		}
		
		for (int i = 0; i < lTemp1.size(); i++) {
			if(lTemp2.contains(lTemp1.get(i).toUpperCase())) {
				nInter++;
			}else {
				lTempUnion.add(lTemp1.get(i));
			}
		}
		
		System.out.println(lTemp1);
		System.out.println(lTemp2);
		System.out.println(lTempUnion);
		
		nUnion = lTempUnion.size();
		
		System.out.println(nInter);
		System.out.println(nUnion);
		
		if(nUnion == 0) {
			nUnion = 1;
		}
		double nTemp = (double)nInter / nUnion;
		if(nTemp == 0) {
			nTemp = 1;
		}
	    return (int) Math.floor(nTemp * 65536);
	}
	
	private static List<String> getPattern(String sInput, boolean bUpper){
		String pattern = "^[a-zA-Z]*$";
		
		List<String> lRet = new ArrayList<>();
		for (int i = 0; i < sInput.length() - 1; i++) {
			String sTemp;
			if(bUpper) {
				sTemp = sInput.substring(i, i+2).toUpperCase();
			}else {
				sTemp = sInput.substring(i, i+2);
			}
			if(Pattern.matches(pattern, sTemp)) {
				lRet.add(sTemp);
			}
		}
		
		return lRet;
	}*/
}
