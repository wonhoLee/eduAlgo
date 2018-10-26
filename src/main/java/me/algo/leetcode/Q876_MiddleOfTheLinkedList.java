package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q876_MiddleOfTheLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode middleNode(ListNode head) {
		ListNode retNode = head;
		int nodeCnt = 0;
		traversal(head, nodeCnt);
		
		int target = nodeCnt / 2;
		for (int i = 0; i < target; i++) {
			retNode = retNode.next;
		}
		
		return retNode;
    }
	
	public void traversal(ListNode self, int cnt) {
		if(self == null) return;
		cnt++;
		traversal(self.next, cnt);
	}
	
	public static void main(String[] args) {
		Q876_MiddleOfTheLinkedList sample = new Q876_MiddleOfTheLinkedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		System.out.println(sample.middleNode(node1).val);
	}
}
