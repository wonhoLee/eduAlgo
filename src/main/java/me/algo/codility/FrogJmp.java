package me.algo.codility;

import java.time.Duration;
import java.time.LocalDateTime;

public class FrogJmp {

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		System.out.println(solution( 10, 85, 30));
		//System.out.println(solution(3, 999111321, 10));
		Duration duration = Duration.between(date, LocalDateTime.now());
		System.out.println(duration);
	}

	public static int solution(int X, int Y, int D) {
		return (int) Math.ceil((double)(Y - X) / D);
    }
	
	
	//CASE 1 : TIME OUT : 44
	/*public static int solution(int X, int Y, int D) {
        int nCnt = 0;
        int nSum = X;
        while(nSum < Y) {
        	nSum += D;
        	nCnt++;
        }
        
        return nCnt;
    }*/
}
