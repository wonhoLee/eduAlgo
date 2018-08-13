package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class LV3_hanoi {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2)));
	}

	private static int[][] solution(int n) {
      int[][] answer;
      
      hanoi(n, 1, 2, 3);
      
      answer = new int[nlTemp.size()][2];
      for (int i = 0; i < nlTemp.size(); i++) {
    	answer[i][0] = nlTemp.get(i)[0];
    	answer[i][1] = nlTemp.get(i)[1];
      }
      return answer;
	}

	static ArrayList<int[]> nlTemp = new ArrayList<>();
	private static void hanoi(int n, int from, int by, int to){
	    if (n == 1) {
	        //move(from, to);
	    	nlTemp.add(new int[]{from, to});
	    }else{
	        hanoi(n - 1, from, to, by);    // 1번  N-1개의 원반을 기둥3을 거쳐 2로 옮긴다.
	        //move(from, to);                // 2번 기둥 1에서 1개의 원반을 기둥 3으롱 롬긴다.
	        nlTemp.add(new int[]{from, to});
	        hanoi(n - 1, by, from, to);    // 3번 기둥 2에서 N-1개의 원반을 기둥 3으로 옮긴다.
	    }
	}
}
