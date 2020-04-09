package me.algo.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class LV1_mara {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution(participant, completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> map = new HashMap<>();
		
		for (String str : participant) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		for (String str : completion) {
			map.put(str, map.get(str) - 1);
		}
		
		for (String key : map.keySet()) {
            if (map.get(key) != 0){
                answer = key;
            }
        }
		
		return answer;
    }

	//case2 : 완료 - Hash 문제이지만 hash 를 사용하지 않음
	/*public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
		Arrays.sort(completion);
		for (int i = 0; i < completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		return participant[i];
        	}
		}
        
        return participant[completion.length];
    }*/
	
	//case 1 : 시간초과
	/*public static String solution(String[] participant, String[] completion) {
        Map<Boolean, List<String>> marathon = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
        	List<String> list = new ArrayList<>();
        	list.add(participant[i]);
        	if(marathon.containsKey(false)) {
        		list.addAll(marathon.get(false));
        	}
        	marathon.put(false, list);
		}
        
        for (int i = 0; i < completion.length; i++) {
        	List<String> listAdd = new ArrayList<>();
        	listAdd.add(completion[i]);
        	if(marathon.containsKey(true)) {
        		listAdd.addAll(marathon.get(true));
        	}
        	marathon.put(true, listAdd);

        	List<String> listRemove = new ArrayList<>();
        	if(marathon.containsKey(false)) {
        		listRemove.addAll(marathon.get(false));
        	}
        	listRemove.remove(completion[i]);
        	marathon.put(false, listRemove);
		}
        
        return marathon.get(false).get(0);
    }*/

}
