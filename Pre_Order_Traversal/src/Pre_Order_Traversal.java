/*
    Problem Statement:
    ------------------
    Given a Binary Tree, perform a Pre-Order Traversal
    (Root → Left → Right) and print all node values in correct order.

    Approach:
    ---------
    Use recursion:
        1. Visit (print) the root
        2. Traverse left subtree
        3. Traverse right subtree

    Time Complexity (TC):
    ---------------------
        O(n)
        - Each node is visited exactly once.

    Space Complexity (SC):
    ----------------------
        O(h), where h = height of tree
        - Stack space due to recursion.
        - Skewed tree:  O(n)
        - Balanced tree: O(log n)
*/

public class Pre_Order_Traversal {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int n) {
            val = n;
        }
    }

    public static void preOrder(Node root)
    {
        if(root == null)
            return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("The Pre Order Traversal of the Binary Tree is as follows: ");
        preOrder(root);

    }
}
