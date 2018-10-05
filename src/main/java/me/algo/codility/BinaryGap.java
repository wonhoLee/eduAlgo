package me.algo.codility;

public class BinaryGap {
	public static int solution(int N) {
        String sTemp = Integer.toBinaryString(N);
        char[] caTemp = String.valueOf(sTemp).toCharArray();
        boolean nFlag = false;
        int nCnt = 0;
        int nRet = 0;
        for(int i = 0; i < caTemp.length ; i++){
            if(caTemp[i] == '1'){
                if(nFlag == true){
                    if(nCnt > nRet){
                        nRet = nCnt;    
                    }
                    nCnt = 0;
                }else{
                    nFlag = true;
                }
            }else{
                if(nFlag == true){
                    nCnt++;
                }
            }
        }
        
        return nRet;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(328));
	}
}
