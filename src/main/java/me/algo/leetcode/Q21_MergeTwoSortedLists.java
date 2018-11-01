package me.algo.leetcode;

public class Q21_MergeTwoSortedLists {
	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		 
	 }
	 
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode ret = null;
		 ListNode cur = null;
	        
	     while(l1 != null || l2 != null){
	    	 if(l2 == null || (l1 != null && l1.val < l2.val)) {
	    		 //pick form l1
	    		 if(ret == null) {
	    			 ret = l1;
	    			 cur = l1;
	    			 l1 = l1.next;
	    		 }else {
	    			 //cur : 1, l1 = 2
	    			 //1 -> 2
	    			 //cur : 2, l1 = 3
	    			 //l1 : 3
	    			 cur.next = l1;
	    			 cur = l1;
	    			 l1 = l1.next;
	    		 }
	    	 }else{
	    		 //pick form l2
	    		 if(ret == null) {
	    			 ret = l2;
	    			 cur = l2;
	    			 l2 = l2.next;
	    		 }else {
	    			 cur.next = l2;
	    			 cur = l2;
	    			 l2 = l2.next;
	    		 }
	    	 }
	     }
	        
	     return ret;
	 }
	 
	 public static void main(String[] args) {
		 ListNode node11 = new ListNode(1);
		 ListNode node12 = new ListNode(2);
		 ListNode node13 = new ListNode(4);
		 
		 node11.next = node12;
		 node12.next = node13;
		 
		 ListNode node21 = new ListNode(1);
		 ListNode node22 = new ListNode(3);
		 ListNode node23 = new ListNode(4);
		 
		 node21.next = node22;
		 node22.next = node23;
		 
		 Q21_MergeTwoSortedLists sample = new Q21_MergeTwoSortedLists();
		 System.out.println(sample.mergeTwoLists(node11, node21));
	 }
}
