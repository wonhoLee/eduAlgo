package me.algo.leetcode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        oddEvenLinkedList.oddEvenList(head);
        ListNode node = head;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = head.next;

        while(p2 != null){
            ListNode t = p2.next;
            if(t == null) break;
            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = connectNode;

        return head;
    }
}
