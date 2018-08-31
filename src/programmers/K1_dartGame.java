package programmers;

public class K1_dartGame {

	public static void main(String[] args) {
		//String dartResult = "1S2D*3T";	//37
		//String dartResult = "1D2S#10S";	//9
		//String dartResult = "1D2S0T";	//3
		String dartResult = "1S*2T*3S";	//23
		
		
		System.out.println(solution(dartResult));
	}
	
	public static int solution(String dartResult) {
		String[] arrTemp = dartResult.split("");
		String sTarget = "";
		int nBeforeScore = 0;
		int nPresentScore = 0;
		int nTotalScore = 0;
		for (int i = 0; i < arrTemp.length; i++) {
			if(arrTemp[i].equals("1") || arrTemp[i].equals("2") || arrTemp[i].equals("3") || arrTemp[i].equals("4") || arrTemp[i].equals("5") ||
					arrTemp[i].equals("6") || arrTemp[i].equals("7")|| arrTemp[i].equals("8") || arrTemp[i].equals("9") || arrTemp[i].equals("0")) {
				sTarget += arrTemp[i];
			}else if(arrTemp[i].equals("S") || arrTemp[i].equals("D") || arrTemp[i].equals("T")){
				nTotalScore += nBeforeScore;
				nBeforeScore = nPresentScore;
				nPresentScore = Integer.parseInt(sTarget);
				sTarget = "";
				if(arrTemp[i].equals("D")) {
					nPresentScore = (int) Math.pow(nPresentScore, 2);
				}else if(arrTemp[i].equals("T")) {
					nPresentScore = (int) Math.pow(nPresentScore, 3);
				}
			}else if(arrTemp[i].equals("*") || arrTemp[i].equals("#")){
				if(arrTemp[i].equals("*")) {
					nBeforeScore = nBeforeScore * 2;
					nPresentScore = nPresentScore * 2;
				}else if(arrTemp[i].equals("#")) {
					nPresentScore = nPresentScore * -1;
				}
			}
		}
		nTotalScore += nBeforeScore;
		nTotalScore += nPresentScore;
		
		return nTotalScore;
	}

}
