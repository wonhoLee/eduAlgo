package algo;

public class gcdlcm {

	public static void main(String[] args) {
		System.out.println(lcm(2, 6));
		System.out.println(gcd3(24, 36));
	}

	public static int gcd(int a,int b)
	{ //반복문을 이용한 방법
	    int mod = a % b;
	    while(mod > 0)
	    {
	        a = b;
	        b = mod;
	        mod = a % b;
	    }
	    return b;
	}
	 
	public static int gcd2(int a,int b)
	{ //재귀 함수형
	    if( a % b == 0 )
	        return b;
	    else
	        return gcd2(b, a % b);
	}
	 
	public static int gcd3(int a, int b)
	{ //삼항 연산자 축약형 
	    return (a % b == 0 ? b : gcd3(b,a%b));
	}
	
	public static int lcm(int a, int b) {
		return a * b / gcd3(a,b);
	}
}

