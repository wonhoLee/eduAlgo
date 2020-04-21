package me.algo.leetcode.bst;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(3));  // returns 4   //8 5 4 3 2
        System.out.println(kthLargest.add(5));   // returns 5   //8 5 5 4 3 2
        System.out.println(kthLargest.add(10));  // returns 5   //10 8 5 5 4 3 2
        System.out.println(kthLargest.add(9));   // returns 8   //10 9 8 5 5 4 3 2
        System.out.println(kthLargest.add(4));   // returns 8   //10 9 8 5 5 4 4 3 2
    }

    int k;
    PriorityQueue<Integer> q;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
