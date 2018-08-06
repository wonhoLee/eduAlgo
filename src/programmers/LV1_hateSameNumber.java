package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class LV1_hateSameNumber {
	public static int[] solution(int []arr) {
        int[] answer = {};
        
        //ArrayList를 이용하여 중복값 계산하여 저장
        ArrayList<Integer> nalRet = new ArrayList<>();
        int nBeforeNum = -1;
		for (int i = 0; i < arr.length; i++) {
			if(nBeforeNum != arr[i]) {
				nBeforeNum = arr[i];
				nalRet.add(arr[i]);
			}
		}
        
		//형변환
		answer = new int[nalRet.size()];
		for (int i = 0; i < nalRet.size(); i++) {
			answer[i] = nalRet.get(i);
		}
        return answer;
	}
	
	public static void main(String[] args) {
		int[] nTemp = {1,1,3,3,0,1,1};
		System.out.println(Arrays.toString(solution(nTemp)));
	}
}
