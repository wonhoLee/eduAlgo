package me.algo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUnique {
    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        firstUnique.showFirstUnique(); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        firstUnique.showFirstUnique(); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        firstUnique.showFirstUnique(); // return -1
    }

    HashMap<Integer, Integer> hashMap;
    Queue<Integer> q;

    public FirstUnique(int[] nums) {
        q = new LinkedList<>();
        hashMap = new HashMap<>();
        for (int num : nums) {
            q.offer(num);
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
    }

    public int showFirstUnique() {
        while(!q.isEmpty()){
            int key = q.peek();
            int curr = hashMap.get(key);
            if(curr == 1) {
                return key;
            }else{
                q.poll();
            }
        }

        return -1;
    }

    public void add(int value) {
        q.offer(value);
        hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
    }
}
