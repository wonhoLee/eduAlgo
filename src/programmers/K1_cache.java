package programmers;

import java.util.LinkedHashMap;
import java.util.Map;

public class K1_cache {

	public static void main(String[] args) {
		/*int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};*/
		int cacheSize = 2;
		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
		
		System.out.println(solution(cacheSize, cities));
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		LRU<String, String> clsTemp = LRU.newInstance(cacheSize); 
		for (int i = 0; i < cities.length; i++) {
			String sTemp = cities[i].toUpperCase();
			if(clsTemp.containsKey(sTemp)) {
				answer++;
			}else {
				answer +=5;
			}
			clsTemp.put(sTemp, sTemp);
		}
		
		return answer;
	}
}

class LRU<K, V> extends LinkedHashMap<K, V> {
    private int size;

    private LRU(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }
    public static <K,V> LRU<K,V> newInstance(int size) {
        return new LRU<K,V>(size);
    }
}
