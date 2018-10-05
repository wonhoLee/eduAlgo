package me.algo.programmers;

public class LV2_hopscotch {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};	//16
		//int[][] land = {{1,3,5,4},{2,1,9,8},{1,2,3,100}};	//113
		//int[][] land = {{5,3,2,1}};	//5
		System.out.println(solution(land));
	}

	//case3 : ��ȸ
	private static int solution(int[][] land) {
		int result = 0;
		int size = land.length;
        // �Լ��� �ϼ��ϼ���.
        for (int i = 0; i < size - 1; i++) {
        	land[i + 1][0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
        	land[i + 1][1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
        	land[i + 1][2] += Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
        	land[i + 1][3] += Math.max(land[i][0], Math.max(land[i][1], land[i][2]));
        }
        result = Math.max(land[size-1][0], Math.max(land[size-1][1], Math.max(land[size-1][2], land[size-1][3])));
        return result;
    }
	
	//case2 : ����
	/*private static int solution(int[][] land) {
        int nMax = 0;
        int nMaxFlag = -1;
        int nMax2 = -1;
        int nMaxFlag2 = -1;
        for (int i = 0; i < land[0].length; i++) {
			if(land[0][i] > nMax) {
				nMax2 = nMax;
				nMaxFlag2 = nMaxFlag;
				
				nMax = land[0][i];
				nMaxFlag = i;
			}
		}
        
        
        return Math.max(calc(nMax, nMaxFlag, land), calc(nMax2, nMaxFlag2, land));
    }
	
	private static int calc(int nFirstValue, int nFirstFlag, int[][] land) {
		int nRet = nFirstValue;
		int nMax = 0;
        int nFlag = nFirstFlag;
        int nTempFlag = 0;
        for (int i = 1; i < land.length; i++) {
        	for (int j = 0; j < land[0].length; j++) {
				if(j != nFlag) {
					if(nMax < land[i][j]) {
						nMax = land[i][j];
						nTempFlag = j;
					}
				}
			}
        	nRet += nMax;
        	nMax = 0;
        	nFlag = nTempFlag;
		}
        
        return nRet;
	}*/
	
	//CASE1 : ����
	/*private static int solution(int[][] land) {
        int answer = 0;

        int nMax = 0;
        int nFlag = -1;
        int nTempFlag = 0;
        for (int i = 0; i < land.length; i++) {
        	for (int j = 0; j < land[0].length; j++) {
				if(j != nFlag) {
					if(nMax < land[i][j]) {
						nMax = land[i][j];
						nTempFlag = j;
					}
				}
			}
        	answer += nMax;
        	nMax = 0;
        	nFlag = nTempFlag;
		}

        return answer;
    }*/
}

