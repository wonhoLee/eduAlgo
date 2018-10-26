package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q876_MiddleOfTheLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
//	public ListNode middleNode(ListNode head) {
//		ListNode retNode = head;
//		ListNode travelNode = head;
//		int nodeCnt = 0;
//		while(travelNode != null) {
//			nodeCnt++;
//			travelNode = travelNode.next;
//		}
//		
//		int target = nodeCnt / 2;
//		for (int i = 0; i < target; i++) {
//			retNode = retNode.next;
//		}
//		
//		return retNode;
//    }
	
	/*
	 * 워커 러너 테크닉
	 * walker : 한번에 한칸
	 * runner : 한번에 두칸
	 * runner 가 끝나면 walker는 중간에 와있음
	 */
	public ListNode middleNode(ListNode head) {
		ListNode walker = head;
		ListNode runner = head;
		
		while(runner != null&&runner.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}
		
		return walker;
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
