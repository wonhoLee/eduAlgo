package hackerrank;

import java.util.Arrays;

public class easy_MarkandToys {

	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		int k = 7;
		
		/*int[] A = {1, 12, 5, 111, 200, 1000, 10};
		int k = 50;	//4
*/		
		System.out.println(maximumToys(A, k));
	}

	static int maximumToys(int[] prices, int k) {
		int nRet = 0;
		int nSum = 0;
		Arrays.sort(prices);
		for (int i = 0; i < prices.length; i++) {
			if((nSum + prices[i]) <= k) {
				nSum += prices[i];
				nRet ++;
			}else {
				break;
			}
		}
		
		return nRet;
	}
}
