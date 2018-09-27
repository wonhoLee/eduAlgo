package programmers.hash;

import java.util.Arrays;

public class LV2_phoneBook {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) {
				if(phone_book[j].indexOf(phone_book[i]) == 0) {
					return false;
				}
			}
		}
        
        return answer;
    }
}
