package me.algo.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class LV2_camouflage {

	public static void main(String[] args) {
		//String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
        //System.out.println(map.toString());
        
        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        
        return answer - 1;
    }

}
