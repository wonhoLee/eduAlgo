package me.algo.hackerrank;

public class Medium_NewYearChaos {

	public static void main(String[] args) {
		//int[] q = {2,1,5,3,4};		//3
		int[] q = {2,5,1,3,4};
		//int[] q = {1,2,5,3,7,8,6,4};	//7
		minimumBribes(q);
	}
	
	private static void minimumBribes(int[] q) {
		int ans = 0;
		boolean bFlag = true;
		for (int i = q.length - 1; i >= 0; i--) {
			if(q[i] - (i+1) > 2) {
				System.out.println("Too chaotic");
				bFlag = false;
				break;
			}
			for (int j = Math.max(0,  q[i] - 2); j < i; j++) {
				if(q[j] > q[i]) ans++;
			}
		}
		if(bFlag) {
			System.out.println(ans);
		}
	}
	
	//CASE1 : �ӵ�����
	/*private static void minimumBribes(int[] q) {
		boolean bFlag = true;
		int nCnt = 0;
		for (int i = 0; i < q.length; i++) {
			if((q[i] - (i+1)) > 2) {
				bFlag = false;
				break;
			}
		}
		
		if(bFlag) {
			
			for (int i = 0; i < q.length; i++) {
				for(int j= 1 ; j < q.length-i; j++) {
					if(q[j]<q[j-1]) {
						nCnt++;
						int temp = q[j-1];
						q[j-1] = q[j];
						q[j] = temp;
					}
				}
			}
			System.out.println(nCnt);
		}else {
			System.out.println("Too chaotic");
		}
		
	}*/

}
