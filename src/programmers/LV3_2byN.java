package programmers;

import java.util.Arrays;

public class LV3_2byN {

	public static void main(String[] args) {
		//System.out.println(solution(4));
		System.out.println(solution(7));
	}
	
	private static int[] aTemp;
	private static int solution(int n) {
		aTemp = new int[n + 1];
		Arrays.fill(aTemp, 0);
		
		return topDown(n); 
	}
	
	private static int topDown(int n) {
		if(n ==0 || n == 1) return 1;
		if(aTemp[n] > 0) return aTemp[n];
		
		aTemp[n] = topDown(n-2) + topDown(n - 1);
		aTemp[n] %= 1_000_000_007;

		return aTemp[n];
	}
	
	//CASE 1 : ¼±´É FAIL
	/*private static int solution(int n) {
		int answer = 0;
	      
	      ArrayList<Integer> alTemp = new ArrayList<>();
	      alTemp.add(1); 
	      alTemp.add(1);
	      for(int i = 2; i<=n ; i++ ){
	          alTemp.add((alTemp.get(i-1) + alTemp.get(i-2)) % 1_000_000_007);
	      }
	      
	      answer = alTemp.get(n) % 1_000_000_007;
	      
	      return answer;
	}*/

}
