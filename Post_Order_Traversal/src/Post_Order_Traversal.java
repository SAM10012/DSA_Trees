/*
    Problem Statement:
    ------------------
    Given a Binary Tree, perform a Post-Order Traversal
    (Left → Right → Root) and print all node values in correct order.

    Approach:
    ---------
    Use recursion:
        1. Traverse left subtree
        2. Traverse right subtree
        3. Visit (print) the root

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

public class Post_Order_Traversal {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int n) {
            val = n;
        }
    }

    public static void postOrder(Node root)
    {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("The Post Order Traversal of the Binary Tree is as follows: ");
        postOrder(root);

    }
}
