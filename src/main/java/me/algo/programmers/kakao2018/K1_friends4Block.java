package me.algo.programmers.kakao2018;

import java.util.Arrays;

public class K1_friends4Block {

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};	//14
		/*int m = 6;
		int n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};	//15
*/		/*int m = 2;
		int n = 2;
		String[] board = {"TT", "TT"};*/
		System.out.println(solution(m, n, board));
	}
	
	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		String[][] arrBoard = new String[m][n];
				
		//�迭ȭ�۾�
		for (int i = 0; i < m; i++) {
			arrBoard[i] = board[i].split("");
		}
		
		while(true) {
			int nTemp;
			//ã�� �� ġȯ
			nTemp = isEqual(arrBoard, m, n);
			
			if(nTemp == 0) {
				break;
			}else {
				answer += nTemp;
			}
			
			//���� �� ����
			setArr(arrBoard);

			for (String[] strings : arrBoard) {
				System.out.println(Arrays.toString(strings));
			}
			System.out.println();
			
		}
		
	    return answer;
	}
	
	private static void setArr(String[][] arrInput) {
		for (int i = arrInput.length-1; i >= 0; i--) {
			for (int j = arrInput[i].length-1; j >= 0; j--) {
				if(arrInput[i][j].equals("")) {
					for (int j2 = i; j2 >= 0; j2--) {
						if(!arrInput[j2][j].equals("")) {
							arrInput[i][j] = arrInput[j2][j];
							arrInput[j2][j] = "";
							break;
						}
					}
				}
			}
		}
	}
	
	private static int isEqual(String[][] arrInput, int m, int n) {
		int nRet = 0;
		char[][] arrTemp = new char[m][n];
		for(int i = 0; i < m; i++){
            Arrays.fill(arrTemp[i], 'c');
        }
		
		for (int i = 0; i < m-1; i++) {
			for (int j = 0; j < n-1; j++) {
				String sTemp1 = arrInput[i][j];
				if(!sTemp1.equals("")) {
					if((sTemp1.equals(arrInput[i+1][j]) && sTemp1.equals(arrInput[i][j+1])) && sTemp1.equals(arrInput[i+1][j+1])) {
						arrTemp[i][j] = 'D';
						arrTemp[i+1][j] = 'D';
						arrTemp[i][j+1] = 'D';
						arrTemp[i+1][j+1] = 'D';
					}
				}
			}
		}
		
		for (int i = 0; i < arrTemp.length; i++) {
			for (int j = 0; j < arrTemp[i].length; j++) {
				if(arrTemp[i][j] == 'D') {
					arrInput[i][j] = "";
					nRet++;
				}
			}
		}
		
		return nRet;
	}
	
	//case 3 : �ٸ���� �����Ͽ� Ǯ��
	/*public static int solution(int m, int n, String[] board) {
		int answer = 0;
		ArrayList<ArrayList<String>> listBoard = new ArrayList<ArrayList<String>>();
		
		//�迭ȭ�۾�
		for(String str : board) {
            ArrayList<String> innerList = new ArrayList<String>();
            for(char c : str.toCharArray()) {
                innerList.add(String.valueOf(c));
            }
            listBoard.add(innerList);
        }
		
		while(true) {
			int nTemp = 0;
			//ã�� �� ġȯ
			nTemp = isEqual(listBoard, m, n);
			
			if(nTemp == 0) {
				break;
			}else {
				answer += nTemp;
			}
			
			//���� �� ����
			arrange(listBoard);
			
			for (int i = 0; i < arrBoard.length; i++) {
				System.out.println(Arrays.toString(arrBoard[i]));
			}
			System.out.println();
			
		}
		
	    return answer;
	}
	
	private static void arrange(ArrayList<ArrayList<String>> board) {
        // ��z �������� Ž�� �Ͽ� ������ ���� ��� �������� ��� �̵��ϸ� ������ �ƴ� ���ڸ� �߰��ϸ� ����������
        for(int i = board.size()-1 ; i >= 0 ; i--) {
            for(int j = board.get(i).size()-1 ; j >= 0 ; j--) {
                if(board.get(i).get(j).isEmpty()) {
                    // ���� �������� Ž���ϸ� ����ƴ� ���ڸ� �߰��� ��� swap
                    for(int k=i; k >= 0; k--) {
                        if(!board.get(k).get(j).isEmpty()) {
                            board.get(i).set(j, board.get(k).get(j));
                            board.get(k).set(j, "");
                            break;
                        }
                    }
                }
            }
        }
    }
	
	private static int isEqual(ArrayList<ArrayList<String>> listBoard, int m, int n) {
		int nRet = 0;
		char[][] arrTemp = new char[m][n];
		for(int i = 0; i < m; i++){
            Arrays.fill(arrTemp[i], 'c');
        }
		
		for (int i = 0; i < m-1; i++) {
			for (int j = 0; j < n-1; j++) {
				String sTemp1 = listBoard.get(i).get(j);
				if(!sTemp1.equals("")) {
					if((sTemp1.equals(listBoard.get(i+1).get(j)) && sTemp1.equals(listBoard.get(i).get(j+1))) && sTemp1.equals(listBoard.get(i+1).get(j+1))) {
						arrTemp[i][j] = 'D';
						arrTemp[i+1][j] = 'D';
						arrTemp[i][j+1] = 'D';
						arrTemp[i+1][j+1] = 'D';
					}
				}
			}
		}
		
		for (int i = 0; i < arrTemp.length; i++) {
			for (int j = 0; j < arrTemp[i].length; j++) {
				if(arrTemp[i][j] == 'D') {
					listBoard.get(i).set(j, "");
					nRet++;
				}
			}
		}
		
		return nRet;
	}*/
	
	//CASE 2: �ӽ� ���̺� ���� �������� ����	-- ������ �˼������� �Ϻ����̽� ����
	/*public static int solution(int m, int n, String[] board) {
		int answer = 0;
		String[][] arrBoard = new String[m][n];
				
		//�迭ȭ�۾�
		for (int i = 0; i < m; i++) {
			arrBoard[i] = board[i].split("");
		}
		
		while(true) {
			int nTemp = 0;
			//ã�� �� ġȯ
			nTemp = isEqual(arrBoard, m, n);
			
			if(nTemp == 0) {
				break;
			}else {
				answer += nTemp;
			}
			
			//���� �� ����
			setArr(arrBoard);
			
			for (int i = 0; i < arrBoard.length; i++) {
				System.out.println(Arrays.toString(arrBoard[i]));
			}
			System.out.println();
			
		}
		
	    return answer;
	}
	
	private static void setArr(String[][] arrInput) {
		for (int i = 0; i < arrInput.length-1; i++) {
			for (int j = 0; j < arrInput[i].length; j++) {
				if(!arrInput[i][j].equals("") && arrInput[i+1][j].equals("")) {
					String sTemp = arrInput[i][j];
					arrInput[i][j] = arrInput[i+1][j];
					arrInput[i+1][j] = sTemp;
				}
			}
		}
	}
	
	private static int isEqual(String[][] arrInput, int m, int n) {
		int nRet = 0;
		char[][] arrTemp = new char[m][n];
		for(int i = 0; i < m; i++){
            Arrays.fill(arrTemp[i], 'c');
        }
		
		for (int i = 0; i < m-1; i++) {
			for (int j = 0; j < n-1; j++) {
				String sTemp1 = arrInput[i][j];
				if(!sTemp1.equals("")) {
					if((sTemp1.equals(arrInput[i+1][j]) && sTemp1.equals(arrInput[i][j+1])) && sTemp1.equals(arrInput[i+1][j+1])) {
						arrTemp[i][j] = 'D';
						arrTemp[i+1][j] = 'D';
						arrTemp[i][j+1] = 'D';
						arrTemp[i+1][j+1] = 'D';
					}
				}
			}
		}
		
		for (int i = 0; i < arrTemp.length; i++) {
			for (int j = 0; j < arrTemp[i].length; j++) {
				if(arrTemp[i][j] == 'D') {
					arrInput[i][j] = "";
					nRet++;
				}
			}
		}
		
		return nRet;
	}*/
	
	//CASE 1: ���� �ϰ�� ����
	/*public static int solution(int m, int n, String[] board) {
		int answer = 0;
		String[][] arrBoard = new String[m][n];
				
		//�迭ȭ�۾�
		for (int i = 0; i < m; i++) {
			arrBoard[i] = board[i].split("");
		}
		
		while(true) {
			int nTemp = 0;
			//ã�� �� ġȯ
			for (int i = 0; i < m-1; i++) {
				for (int j = 0; j < n-1; j++) {
					String sTemp1 = arrBoard[i][j];
					if(!sTemp1.equals("!")) {
						nTemp += isEqual(arrBoard, m, n, sTemp1, i, j);
					}
				}
			}
			
			if(nTemp == 0) {
				break;
			}else {
				answer += nTemp;
			}
			
			//���� �� ����
			setArr(arrBoard);
			
			for (int i = 0; i < arrBoard.length; i++) {
				System.out.println(Arrays.toString(arrBoard[i]));
			}
			System.out.println();
			
		}
		
	    return answer;
	}
	
	private static void setArr(String[][] arrInput) {
		for (int i = 0; i < arrInput.length-1; i++) {
			for (int j = 0; j < arrInput[i].length; j++) {
				if(!arrInput[i][j].equals("!") && arrInput[i+1][j].equals("!")) {
					String sTemp = arrInput[i][j];
					arrInput[i][j] = arrInput[i+1][j];
					arrInput[i+1][j] = sTemp;
				}
			}
		}
	}
	
	private static int isEqual(String[][] arrInput, int m, int n, String sInput, int i, int j) {
		int nRet = 0;
		if( i == (m-1) || j == (n-1)) {
			return 0;
		}
		
		String sTemp2 = arrInput[i+1][j];
		String sTemp3 = arrInput[i][j+1];
		String sTemp4 = arrInput[i+1][j+1];
		if((sInput.equals(sTemp2) || sTemp2.equals("@")) && (sInput.equals(sTemp3) || sTemp3.equals("@")) && (sInput.equals(sTemp4) || sTemp4.equals("@"))) {
			int nCnt = 0 ;
			if(arrInput[i][j].equals(sInput)) {
				nCnt++;
			}
			if(arrInput[i+1][j].equals(sInput)) {
				nCnt++;
			}
			if(arrInput[i][j+1].equals(sInput)) {
				nCnt++;
			}
			if(arrInput[i+1][j+1].equals(sInput)) {
				nCnt++;
			}
			arrInput[i][j] = "@";
			arrInput[i+1][j] = "@";
			arrInput[i][j+1] = "@";
			arrInput[i+1][j+1] = "@";
			
			nRet += isEqual(arrInput, m, n, sInput, i + 1, j);
			nRet += isEqual(arrInput, m, n, sInput, i, j + 1);
			nRet += isEqual(arrInput, m, n, sInput, i + 1, j + 1);
			
			arrInput[i][j] = "!";
			arrInput[i+1][j] = "!";
			arrInput[i][j+1] = "!";
			arrInput[i+1][j+1] = "!";
			return nRet += nCnt;
		}
		return 0;
	}*/

}
