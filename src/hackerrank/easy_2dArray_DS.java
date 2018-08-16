package hackerrank;

public class easy_2dArray_DS {

	public static void main(String[] args) {
		//int[][] arr = {{1,1,1,0,0,0}, {0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
		//int[][] arr = {{-9,-9,-9,1,1,1}, {0,-9,0,4,3,2},{-9,-9,-9,1,2,3},{0,0,8,6,6,0},{0,0,0,-2,0,0},{0,0,1,2,4,0}};
		int[][] arr = {{1,1,1,0,0,0}, {0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,4,4,0},{0,0,0,2,0,0},{0,0,1,2,4,0}};
		System.out.println(hourglassSum(arr));
	}

	static int hourglassSum(int[][] arr) {
		int nAnswer = -9;
		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 1; j < arr[i].length - 1; j++) {
				int nTemp = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] + arr[i][j] + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
				if(nAnswer < nTemp) {
					nAnswer = nTemp;
				}
			}
		}
		
		return nAnswer;

    }
}
