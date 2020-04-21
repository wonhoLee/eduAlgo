package me.algo.structure.tree;

/*
https://www.youtube.com/watch?v=QN1rZYX6QaA
     (1)
   (2) (3)
(4)  (5)
inorder : left, root, right 4 2 5 1 3
Preorder : root, left, right 1 2 4 5 3
postorder : left, right, root 4 5 2 3 1
 */
class Tree2 {
    public Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node Node = new Node(data);
        Node.left = left;
        Node.right = right;
        return Node;
    }

    public void inorder(Node Node) {
        if (Node != null) {
            inorder(Node.left);
            System.out.println(Node.data);
            inorder(Node.right);
        }
    }

    public void preorder(Node Node) {
        if (Node != null) {
            System.out.println(Node.data);
            preorder(Node.left);
            preorder(Node.right);
        }
    }

    public void postorder(Node Node) {
        if (Node != null) {
            postorder(Node.left);
            postorder(Node.right);
            System.out.println(Node.data);
        }
    }
}

public class TreeTraversal {

    public static void main(String[] args) {
        Tree2 t = new Tree2();
        Node n4 = t.makeNode(null, 4, null);
        Node n5 = t.makeNode(null, 5, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);

        t.setRoot(n1);
        t.inorder(t.getRoot());
        System.out.println();
        t.preorder(t.getRoot());
        System.out.println();
        t.postorder(t.getRoot());
    }
}
