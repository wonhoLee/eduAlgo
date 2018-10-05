package me.algo.programmers;

public class LV1_numPlus {

	public static void main(String[] args) {
		int N = 123;
		//int N = 987;
		System.out.println(solution(N));
	}
	
	//�ٸ������ Ǯ��
	public static int solution(int n) {
        return String.valueOf(n).chars().map(i -> Integer.parseInt(String.valueOf((char)i))).sum();
    }
	
	//case 1 : ���� Ǯ��
	/*public static int solution(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(i -> Integer.parseInt(i)).sum();
    }*/

}
