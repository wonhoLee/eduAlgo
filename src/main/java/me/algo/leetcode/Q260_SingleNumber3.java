package me.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Q260_SingleNumber3 {
//	public int[] singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//			map.put(num, map.getOrDefault(num, 0) + 1);
//		}
//        int nRet1 = 0;
//        int nCnt = 0;
//        for (Integer keyValue : map.keySet()) {
//        	if(map.get(keyValue) == 1) {
//				if(nCnt == 0) {
//					nRet1 = keyValue;
//					nCnt++;
//				}else {
//					return new int[] {nRet1, keyValue};
//				}
//			}
//		}
//        
//        return null;
//    }
	
	/*
	 * XOR
	 * 1. a a b b c d 전부다 XOR = c^d
	 * 2. c^d 적어도 한비트는 1
	 * 3. 그 1비트자리에서 c:0 d:1 혹은 그 반대
	 * 4. 그 1비트자리를 기준으로 모든 원소를 두 그룹으로 나눌 수 있음
	 * 5. 각 그룹마다 유일하게 등장하는 원소는 하나
	 */
	public int[] singleNumber(int[] nums) {
        int xor = 0;
        //1
        for(int num:nums) xor^=num;
        //2
        int idx = 0;
        for (int i = 0; i < 32; i++) {
			if(((xor>>i) & 1) == 1) {
				idx = i;
				break;
			}
		}
        //5
        int xor1 = 0;
        int xor2 = 0;
        for(int num:nums) {
        	if(((num>>idx) & 1) == 1) {
        		xor1 ^= num;
        	}else {
        		xor2 ^= num;
        	}
        }
        
        return new int[] {xor1, xor2};
    }
	
	public static void main(String[] args) {
		Q260_SingleNumber3 exClass = new Q260_SingleNumber3();
		//int[] nums = {1,2,1,3,2,5};
		int[] nums = {0,1};
		System.out.println(Arrays.toString(exClass.singleNumber(nums)));
	}
}
