package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class medium_FrequencyQueries {

	public static void main(String[] args) {
		//int[][] nTemp = {{1, 5},{1, 6},{3, 2},{1, 10},{1, 10},{1, 6},{2, 5},{3, 2}};	// 0, 1
		//int[][] nTemp = {{3, 4},{2, 1003},{1, 16},{3, 1}}; 	// 0, 1
		int[][] nTemp = {{1, 3},{2, 3},{3, 2},{1, 4},{1, 5},{1, 5},{1, 4},{3, 2},{2, 4},{3, 2}}; 	// 0, 1, 1
		
		//List<List<Integer>> queries = new ArrayList<>();
		List<int[]> queries = new ArrayList<>();
		for (int i = 0; i < nTemp.length; i++) {
			queries.add(
					/*Arrays.stream(nTemp[i]).boxed().collect(Collectors.toList())*/
					nTemp[i]
					);
		}
		
		System.out.println(freqQuery(queries).toString());

	}
	
	static List<Integer> freqQuery(List<int[]> queries) {
		List<Integer> lRet = new ArrayList<>();
		HashMap<Integer, Integer> hTemp1 = new HashMap<>();
		HashMap<Integer, Integer> hTemp2 = new HashMap<>();
		
		for (int i = 0; i < queries.size(); i++) {
			int nValue0 = queries.get(i)[0];
			int nValue1 = queries.get(i)[1];
			
			/*switch (nValue0) {
			case 1:
				hTemp1.getOrDefault(key, defaultValue)
				if(hTemp.containsKey(nValue1)) {
					hTemp.put(nValue1, hTemp.get(nValue1)+1);
				}else {
					hTemp.put(nValue1, 1);
				}
				break;
			case 2:
				if(hTemp.containsKey(nValue1)) {
					if(hTemp.get(nValue1) < 2) {
						hTemp.remove(nValue1);
					}else {
						hTemp.put(nValue1, hTemp.get(nValue1)-1);
					}
				}
				break;
			case 3:
				if(hTemp.containsValue(nValue1)) {
					lRet.add(1);
				}else {
					lRet.add(0);
				}
				break;
			default:
				break;
			}*/
		}
		
		return lRet;
	}
	
	//CASE 4 : TIME oUT
	/*static List<Integer> freqQuery(List<int[]> queries) {
		List<Integer> lRet = new ArrayList<>();
		HashMap<Integer, Integer> hTemp = new HashMap<>();
		
		for (int i = 0; i < queries.size(); i++) {
			int nValue0 = queries.get(i)[0];
			int nValue1 = queries.get(i)[1];
			
			switch (nValue0) {
			case 1:
				if(hTemp.containsKey(nValue1)) {
					hTemp.put(nValue1, hTemp.get(nValue1)+1);
				}else {
					hTemp.put(nValue1, 1);
				}
				break;
			case 2:
				if(hTemp.containsKey(nValue1)) {
					if(hTemp.get(nValue1) < 2) {
						hTemp.remove(nValue1);
					}else {
						hTemp.put(nValue1, hTemp.get(nValue1)-1);
					}
				}
				break;
			case 3:
				if(hTemp.containsValue(nValue1)) {
					lRet.add(1);
				}else {
					lRet.add(0);
				}
				break;
			default:
				break;
			}
			
		}
		
		return lRet;
    }*/
	
	//CASE3 : TIME oUT
//	static List<Integer> freqQuery(List<List<Integer>> queries) {
//		List<Integer> lRet = new ArrayList<>();
//		HashMap<Integer, Integer> hTemp = new HashMap<>();
//		
//		for (int i = 0; i < queries.size(); i++) {
//			int nValue0 = queries.get(i).get(0);
//			int nValue1 = queries.get(i).get(1);
//			
//			switch (nValue0) {
//			case 1:
//				if(hTemp.containsKey(nValue1)) {
//					hTemp.put(nValue1, hTemp.get(nValue1)+1);
//				}else {
//					hTemp.put(nValue1, 1);
//				}
//				break;
//			case 2:
//				if(hTemp.containsKey(nValue1)) {
//					if(hTemp.get(nValue1) < 2) {
//						hTemp.remove(nValue1);
//					}else {
//						hTemp.put(nValue1, hTemp.get(nValue1)-1);
//					}
//				}
//				break;
//			case 3:
//				if(hTemp.containsValue(nValue1)) {
//					lRet.add(1);
//				}else {
//					lRet.add(0);
//				}
//				break;
//			default:
//				break;
//			}
//			
//		}
//		
//		return lRet;
//    }
	
	//CASE 2 : TIME OUT
	/*static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> lRet = new ArrayList<>();
		List<Integer> lTemp = new LinkedList<>();
		
		for (int i = 0; i < queries.size(); i++) {
			int nValue0 = queries.get(i).get(0);
			int nValue1 = queries.get(i).get(1);
			
			switch (nValue0) {
			case 1:
				lTemp.add(0, nValue1);
				break;
			case 2:
				if(lTemp.size() > 0 && lTemp.indexOf(nValue1) != -1){
					lTemp.remove(lTemp.indexOf(nValue1));
				}
				break;
			case 3:
				if(chkListValueCnt(lTemp, nValue1) == true) {
					lRet.add(1);
				}else {
					lRet.add(0);
				}
				break;
			default:
				break;
			}
			
		}
		
		return lRet;
    }
	
	static boolean chkListValueCnt(List<Integer> lValue, int nValue) {
		boolean bTrue = false;
		
		if(lValue.size() > 1) {
			List<Integer> lTemp = new ArrayList<>();
			lTemp.addAll(lValue);
			lTemp.sort(null);
			
			int nBeforeValue = lTemp.get(0);
			int nCnt = 1;
			
			for (int i = 1; i <= lTemp.size(); i++) {
				if(lTemp.size() == i) {
					if(nCnt == nValue) {
						bTrue = true;
					}
				}else {
					if(nBeforeValue == lTemp.get(i)) {
						nCnt++;
					}else {
						if(nCnt == nValue) {
							bTrue = true;
							break;
						}else {
							nBeforeValue = lTemp.get(i);
							nCnt=1;
						}
					}
				}
				
			}
		}else if(lValue.size() == 1 && nValue == 1){
			bTrue = true;
		}
		
		return bTrue;
	}*/
	
	//CASE 1: Test Fail & Time over
	/*static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> lRet = new ArrayList<>();
		List<Integer> lTemp = new LinkedList<>();
		
		for (int i = 0; i < queries.size(); i++) {
			int nValue0 = queries.get(i).get(0);
			int nValue1 = queries.get(i).get(1);
			
			switch (nValue0) {
			case 1:
				lTemp.add(nValue1);
				break;
			case 2:
				if(lTemp.size() > 0 && lTemp.indexOf(nValue1) != -1){
					lTemp.remove(lTemp.indexOf(nValue1));
				}
				break;
			case 3:
				if(chkListValueCnt(lTemp, nValue1) == true) {
					lRet.add(1);
				}else {
					lRet.add(0);
				}
				break;
			default:
				break;
			}
			
		}
		
		return lRet;
    }
	
	static boolean chkListValueCnt(List<Integer> lTemp, int nValue) {
		boolean bTrue = false;
		
		if(lTemp.size() > 1) {
			int nBeforeValue = lTemp.get(0);
			int nCnt = 1;
			
			for (int i = 1; i < lTemp.size(); i++) {
				if(nBeforeValue == lTemp.get(i)) {
					nCnt++;
				}else {
					if(nCnt == nValue) {
						bTrue = true;
						break;
					}else {
						nCnt=1;
						nBeforeValue = lTemp.get(i);
					}
				}
			}
		}else if(lTemp.size() == 1 && nValue == 1){
			bTrue = true;
		}
		
		return bTrue;
	}*/
}
