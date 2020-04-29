package me.algo.programmers.kakao2018;

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
		for (String city : cities) {
			String sTemp = city.toUpperCase();
			if (clsTemp.containsKey(sTemp)) {
				answer++;
			} else {
				answer += 5;
			}
			clsTemp.put(sTemp, sTemp);
		}

		return answer;
	}
}

class LRU<K, V> extends LinkedHashMap<K, V> {
	private final int size;

	private LRU(int size) {
		super(size, 0.75f, true);
		this.size = size;
	}

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > size;
	}

	public static <K, V> LRU<K, V> newInstance(int size) {
		return new LRU<K, V>(size);
    }
}
