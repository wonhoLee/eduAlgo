package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class medium_CountTriplets {

	public static void main(String[] args) {
		List<Long> arr = new ArrayList<>();
		arr.add((long) 1);
		arr.add((long) 4);
		arr.add((long) 16);
		arr.add((long) 64);
		long r = 4;
		
		System.out.println(countTriplets(arr, r));
	}

	private static long countTriplets(List<Long> arr, long r) {
		long nRet = 0;
		List<Long> alTemp = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			alTemp.set(i, arr.get(0) / r);
		}
		
		return nRet;
    }
}
