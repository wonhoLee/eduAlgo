package me.algo.programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LV3_bestAlbum {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};	//4,1,3,0
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(solution(genres, plays)));
	}

	//다른사람코드 참조함
	//http://sunpil.tistory.com/35
	//http://mstst33.com/best_ablum/129/
	static class Chart implements Comparable<Chart>{
		int id;
		int play;
		public Chart(int id, int play) {
			super();
			this.id = id;
			this.play = play;
		}
		@Override
		public String toString() {
			return "Chart [id=" + id + ", play=" + play + "]";
		}
		@Override
        public int compareTo(Chart chart) {
            if(this.play > chart.play) return -1;
            if(this.play==chart.play) return 0;
            return 1;
        }
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Chart>> idMap = new HashMap<>(); 
        
        for (int i = 0; i < genres.length; i++) {
        	map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        	
        	List<Chart> list = idMap.getOrDefault(genres[i], new ArrayList<>());
        	list.add(new Chart(i, plays[i]));
        	idMap.put(genres[i], list);
		}
        
        List<String> gList = new ArrayList<>();
        gList.addAll(map.keySet());
        
        Collections.sort(gList, (arg0, arg1) -> {
				if(map.get(arg0) > map.get(arg1)) return -1;
				else if(map.get(arg0) == map.get(arg1)) return 0;
				else return 1;
			}
		);
        
        List<Integer> returnList = new ArrayList<>();
        for(String str : gList) {
			List<Chart> list = idMap.get(str);
			Collections.sort(list);
			
			returnList.add(list.get(0).id);
			if(list.size() > 1) {
				returnList.add(list.get(1).id);
			}
		}
        
        return returnList.stream().mapToInt(s->s).toArray();
    }
}
