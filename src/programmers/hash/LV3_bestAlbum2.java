package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LV3_bestAlbum2 {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};	//4,1,3,0
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(solution(genres, plays)));
	}

	//반복연습용
	public static int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> totalMap = new HashMap<>();
		Map<String, List<Chart>> chartMap = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
			
			List<Chart> cList = chartMap.getOrDefault(genres[i], new ArrayList<>());
			cList.add(new Chart(i, plays[i]));
			chartMap.put(genres[i], cList);
		}
		
		List<String> totalList = new ArrayList<>();
		totalList.addAll(totalMap.keySet());
		Collections.sort(totalList, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				if(totalMap.get(arg0) > totalMap.get(arg1)) return -1;
				else if(totalMap.get(arg0) == totalMap.get(arg1)) return 0;
				else return 1;
			}
		});
		
		List<Integer> answerList = new ArrayList<>();
		for (int i = 0; i < totalList.size(); i++) {
			List<Chart> chart = chartMap.get(totalList.get(i));
			Collections.sort(chart);
			
			answerList.add(chart.get(0).index);
			if(chart.size() > 1) {
				answerList.add(chart.get(1).index);
			}
		}
		
        return answerList.stream().mapToInt(s->s).toArray();
    }
	
	static class Chart implements Comparable<Chart>{
		int index;
		int play;
		
		public Chart(int index, int play) {
			super();
			this.index = index;
			this.play = play;
		}

		@Override
		public String toString() {
			return "Chart [index=" + index + ", play=" + play + "]";
		}

		@Override
		public int compareTo(Chart arg0) {
			if(this.play > arg0.play) return -1;
			else if(this.play == arg0.play) return 0;
			else return 1;
		}
	}
}
