package me.algo.leetcode.recursion;

import me.algo.leetcode.ListNode;

public class SwapNodes {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SwapNodes swapNodes = new SwapNodes();
        ListNode node = swapNodes.swapPairs(node1);

        do{
            System.out.println(node.val);
            node = node.next;
        }while(node!=null);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        //1
        ListNode tmp = head.next;
        head.next = tmp.next;
        tmp.next = head;

        if(tmp.next.next != null && tmp.next.next.next != null) tmp.next.next = swapPairs(tmp.next.next);

        return tmp;
    }

}
