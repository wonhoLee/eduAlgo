package hackerrank;

public class betweenTwoSets {

	public static void main(String[] args) {
		int[] a = {2, 4};
		int[] b = {16, 32, 96};
		//int[] a = {3, 4};
		//int[] b = {24, 48};
		System.out.println(getTotalX(a, b));
	}

	static int getTotalX(int[] a, int[] b) {
        int nCnt = 0;
        int nLcm = 0;
        int nGcd = 0;
		
        if(a.length > 1) {
        	nLcm = lcm(a[0], a[1]);
            for (int i = 2; i < a.length; i++) {
            	nLcm = lcm(nLcm, a[i]); 
    		}
        }else {
        	nLcm = a[0];
        }
        
        if(b.length > 1) {
        	nGcd = gcd(b[0], b[1]);
            for (int i = 2; i < b.length; i++) {
            	nGcd = gcd(nGcd, b[i]); 
    		}
        }else {
        	nGcd = b[0];
        }
        
        for (int i = nLcm; i <= nGcd; i+=nLcm) {
        	if( chkDivide(b, i) == true){
        		nCnt++;
        	}
		}	
        
        return nCnt;
    }
	
	public static boolean chkDivide(int b[], int i) {
		for (int j = 0; j < b.length; j++) {
			if((b[j] % i ) != 0){
				return false;
			}
		}
		return true;
	}
	
	public static int gcd(int a, int b)
	{ 
		return (a % b == 0 ? b : gcd(b,a%b));
	}
	
	public static int lcm(int a, int b) {
		return a * b / gcd(a,b);
	}
	
    
}
