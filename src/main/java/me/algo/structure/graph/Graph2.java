package me.algo.structure.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph2 {
	static class Node{
		public int val;
		public List<Node> children;
		public Node() {}
		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
	public int maxDepth(Node root) {
		int ret = 0;
		if(root == null) return 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			ret++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				for(Node child:node.children) {
					q.offer(child);
				}
			}
		}
		return ret;
	}
	
		
	public static void main(String[] args) {
		
	}
}
