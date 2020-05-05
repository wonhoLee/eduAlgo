package me.algo.codility;

public class BinaryGap {
	public static int solution(int N) {
	    String str = Integer.toBinaryString(N);
        System.out.println(str);
        boolean nFlag = false;
        int nCnt = 0;
        int nRet = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                if (nFlag) {
                    nRet = Math.max(nRet, nCnt);

                    nCnt = 0;
                } else {
                    nFlag = true;
                }
            } else {
                if (nFlag) {
                    nCnt++;
                }
            }
        }
        
        return nRet;
    }

    public static int solution2(int N) {
        String str = Integer.toBinaryString(N);
        int answer = 0;
        int tmp = 0;
        boolean flag = false;
        for(Character c : str.toCharArray()){
            if(c == '0'){
                if(flag){
                    tmp++;
                }
            }else{
                if(flag){
                    answer = Math.max(answer, tmp);
                    tmp=0;
                }else{
                    flag = true;
                }
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution(328));
        System.out.println(solution2(328));
	}
}
