package me.algo.hackerrank;

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
		//int[][] nTemp = {{1, 3},{2, 3},{3, 2},{1, 4},{1, 5},{1, 5},{1, 4},{3, 2},{2, 4},{3, 2}}; 	// 0, 1, 1
		int[][] nTemp = {{1, 89},{3, 15},{1, 12},{1, 47},{1, 23},{1, 66},{2, 28},{3, 2},{2, 15},{1, 16},{3, 16},{1, 17},{1, 73},{2, 44},{3, 14},{2, 30},{2, 38},{2, 4},{1, 4},{2, 35},{1, 28},{1, 9},{1, 68},{3, 1},{3, 33},{3, 5},{1, 36},{1, 30},{3, 22},{1, 72},{1, 68},{1, 62},{1, 88},{1, 79},{2, 9},{1, 10},{2, 44},{3, 38},{2, 13},{1, 61},{3, 3},{1, 78},{2, 27},{1, 28},{3, 23},{1, 92},{3, 9},{1, 13},{3, 48},{3, 12},{2, 47},{3, 25},{1, 23},{1, 66},{1, 77},{3, 5},{3, 20},{2, 12},{1, 87},{1, 93},{2, 33},{2, 6},{1, 55},{3, 20},{3, 34},{2, 15},{1, 31},{2, 29},{2, 2},{3, 43},{2, 39},{3, 6},{1, 72},{3, 18},{3, 35},{3, 47},{1, 59},{3, 43},{2, 9},{1, 6},{1, 7},{1, 5},{1, 32},{1, 81},{1, 22},{1, 9},{2, 37},{2, 41},{3, 20},{3, 23},{2, 33},{2, 5},{2, 30},{2, 39},{2, 24},{1, 63},{1, 5},{1, 7},{2, 44},{3, 6},{3, 49}};
		
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
		int nTemp = 0;
		for (int i = 0; i < queries.size(); i++) {
			int nValue0 = queries.get(i)[0];
			int nValue1 = queries.get(i)[1];
			switch (nValue0) {
			case 1:
				nTemp = hTemp1.getOrDefault(nValue1, 0) + 1;
				hTemp1.put(nValue1, nTemp);
				if(nTemp - 1 != 0) {
					hTemp2.put(nTemp - 1, hTemp2.getOrDefault(nTemp - 1, 1) - 1);
				}
				hTemp2.put(nTemp, hTemp2.getOrDefault(nTemp, 0) + 1);
				break;
			case 2:
				nTemp = hTemp1.getOrDefault(nValue1, 1) - 1;
				if(nTemp != 0) {
					hTemp1.put(nValue1, nTemp);
					hTemp2.put(nTemp + 1, hTemp2.getOrDefault(nTemp + 1, 1) - 1);
					hTemp2.put(nTemp, hTemp2.getOrDefault(nTemp, 0) + 1);
				}
				break;
			case 3:
				if(hTemp2.getOrDefault(nValue1, 0) > 0 ) {
					lRet.add(1);
				}else {
					lRet.add(0);
				}
				break;
			default:
				break;
			}
			
			System.out.println("nValue0 : " + nValue0 + " nValue1 : " + nValue1 + " hTemp1 : " + hTemp1.toString() + " hTemp2 : " + hTemp2.toString());
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
