package me.algo.programmers.kakao2018;

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
		StringBuilder sTarget = new StringBuilder();
		int nBeforeScore = 0;
		int nPresentScore = 0;
		int nTotalScore = 0;
		for (String s : arrTemp) {
			switch (s) {
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
				case "0":
					sTarget.append(s);
					break;
				case "S":
				case "D":
				case "T":
					nTotalScore += nBeforeScore;
					nBeforeScore = nPresentScore;
					nPresentScore = Integer.parseInt(sTarget.toString());
					sTarget = new StringBuilder();
					if (s.equals("D")) {
						nPresentScore = (int) Math.pow(nPresentScore, 2);
					} else if (s.equals("T")) {
						nPresentScore = (int) Math.pow(nPresentScore, 3);
					}
					break;
				case "*":
				case "#":
					if (s.equals("*")) {
						nBeforeScore = nBeforeScore * 2;
						nPresentScore = nPresentScore * 2;
					} else if (s.equals("#")) {
						nPresentScore = nPresentScore * -1;
					}
					break;
			}
		}
		nTotalScore += nBeforeScore;
		nTotalScore += nPresentScore;

		return nTotalScore;
	}

}
