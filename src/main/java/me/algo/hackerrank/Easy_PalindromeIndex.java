package me.algo.hackerrank;

public class Easy_PalindromeIndex {

	public static void main(String[] args) {
		String s = "aaab";
		System.out.println(palindromeIndex(s));
	}

	static int palindromeIndex(String s) {
		int nRet = 0;
		
		if(isPan(s)) {
			return -1;
		}else {
			for (int i = s.length() - 1; i >= 0; i--) {
				if(isPan(s.substring(0, i) + s.substring(i + 1))) {
					return i;
				}
			}
		}
		
		return nRet;
    }
	
	public static boolean isPan(String sInput) {
		if(sInput.equals(new StringBuilder(sInput).reverse().toString())) {
			return true;
		}else {
			return false;
		}
	}
	
	//CASE 1 : �ӵ� ����
	/*static int palindromeIndex(String s) {
		int nRet = 0;
		
		if(isPan(s)) {
			return -1;
		}else {
			for (int i = 0; i < s.length(); i++) {
				String sTemp1 = s.substring(0, i);
				String sTemp2 = "";
				if(i + 1 < s.length()) {
					sTemp2 = s.substring(i + 1, s.length());
				}
				if(isPan(sTemp1 + sTemp2)) {
					nRet = i;
				}
			}
		}
		
		return nRet;
    }
	
	public static boolean isPan(String sInput) {
		if(sInput.equals(new StringBuilder(sInput).reverse().toString())) {
			return true;
		}else {
			return false;
		}
	}*/
}
