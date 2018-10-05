package me.algo.algo;

public class hanoi {

	public static void main(String[] args) {
		hanoi(2, 1, 2, 3);
	}

	private static void move(int from, int to){
	    System.out.println("Move from " + from + " to " + to);
	}

	// n���� ������ from ���� by�� ���� to�� �ű��.
	private static void hanoi(int n, int from, int by, int to){
	    if (n == 1)
	        move(from, to);
	    else{
	        hanoi(n - 1, from, to, by);    // 1��  N-1���� ������ ���3�� ���� 2�� �ű��.
	        move(from, to);                // 2�� ��� 1���� 1���� ������ ��� 3���� �ұ��.
	        hanoi(n - 1, by, from, to);    // 3�� ��� 2���� N-1���� ������ ��� 3���� �ű��.
	    }
	}
}
