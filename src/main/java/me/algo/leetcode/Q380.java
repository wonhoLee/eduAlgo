package me.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//https://www.youtube.com/watch?v=dei_SHqRIZ8
//https://leetcode.com/problems/insert-delete-getrandom-o1/
public class Q380 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> test = new HashMap<>();
        System.out.println(test.put(0, 0));
        System.out.println(test.put(0, 0));

        System.out.println(test.remove(1));
        System.out.println(test.remove(0));
    }

    Map<Integer, Integer> hashMap;
    ArrayList<Integer> list;
    int size;
    Random r = new Random();

    public Q380() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (hashMap.containsKey(val)) return false;
        hashMap.put(val, size++);
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) return false;
        int idx = hashMap.get(val);
        hashMap.remove(val);
        if (idx != size - 1) {
            int swap = list.get(size - 1);
            list.set(idx, swap);
            hashMap.put(swap, idx);
        }
        list.remove(--size);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int idx = r.nextInt(size);
        return list.get(idx);
    }
}
