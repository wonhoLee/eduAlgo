package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode node = reverseLinkedList.reverseList2(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    //Won
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null) {
            listNodeList.add(head);
            head = head.next;
        }

        listNodeList.get(0).next = null;
        for (int i = 1; i < listNodeList.size(); i++) {
            ListNode target = listNodeList.get(i);
            target.next = listNodeList.get(i - 1);
        }

        return listNodeList.get(listNodeList.size() - 1);
    }

    //solution
    public ListNode reverseList11(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //soulution
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
