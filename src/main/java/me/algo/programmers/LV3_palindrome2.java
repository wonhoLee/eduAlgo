package me.algo.programmers;

public class LV3_palindrome2 {
	//�ٸ����Ǯ��
	public static void main(String[] args) {
		//System.out.println(solution("abcdcba"));
		//System.out.println(solution("atabacdeaa"));
		System.out.println(solution("aabcdfg"));
	}

	public static int solution(String s)
    {
       int left = 0, right = 0;
        int result = 1;

        if(s.length() != 1) {
            for (int center = 1; center < s.length() - 1; center++) {
                left = center - 1;
                right = center + 1;
                while (left >= 0 && right <= s.length() - 1) {
                    if (s.charAt(left) != s.charAt(right))
                        break;

                    result = right - left + 1 > result ? right - left + 1 : result;
                    left--;
                    right++;
                }
            }
            
            //ù���ڰ� center�ϰ�� ����
            for (int center = 0; center <= s.length() - 2; center++) {
                left = center;
                right = center + 1;
                while (left >= 0 && right <= s.length() - 1) {
                    if (s.charAt(left) != s.charAt(right))
                        break;
                    result = right - left + 1 > result ? right - left + 1 : result;
                    left--;
                    right++;
                }
            }
        }

        return result;
    }
}
