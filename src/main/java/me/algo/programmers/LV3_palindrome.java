package me.algo.programmers;

public class LV3_palindrome {

	public static void main(String[] args) {
		//System.out.println(solution("abcdcba"));
		System.out.println(solution("atabacde"));
		//System.out.println(Arrays.toString(getPartialMatch("abcdcba")));
	}

	private static int solution(String s)
    {
        int nRet = 0;
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
        	int nTemp = maxOverlap(s, r.substring(i));
        	if(nRet < nTemp) {
        		nRet = nTemp;
        	}
		}
        
        //System.out.println(maxOverlap(s, r.substring(3)));
        return nRet;
    }
	
	private static int maxOverlap(String s, String r) {
		char[]a = s.toCharArray();
        char[]b = r.toCharArray();
        int n = s.length();
        int m = r.length();
        int[] pi = getPartialMatch(r);
        int begin = 0, matched = 0;
        while(begin < n){
        	//System.out.println("a[begin + matched] : " + a[begin + matched] + " b[matched] : " + b[matched]);
        	if(matched < m && a[begin + matched] == b[matched]) {
        		matched++;
        		if(begin + matched == m) {
        			return matched;
        		}
        	}else {
        		if(matched == 0) {
        			begin++;
        		}else {
        			begin += matched - pi[matched - 1];
        			matched = pi[matched-1];
        		}
        	}
        }
        return 0;
	}
	
	private static int[] getPartialMatch(String s) {
    	char[] N = s.toCharArray();
		int m = s.length();
    	int[] pi = new int[m];
    	
    	int begin = 1, matched = 0;
    	while(begin + matched < m) {
    		if(N[begin + matched] == N[matched]) {
    			++matched;
    			pi[begin+matched-1] = matched;
    		}else {
    			if(matched == 0) {
    				begin++;
    			}else {
    				begin += matched - pi[matched-1];
    				matched = pi[matched-1];
    			}
    		}
    	}
    	
    	return pi;
    }
}
