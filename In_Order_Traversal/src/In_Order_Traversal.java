/* Problem Statement

Given a Binary Tree, perform an In-Order Traversal (Left → Root → Right) and print all node values in correct order.

✅ Approach

Use recursion to traverse:

Traverse left subtree

Visit (print) the root

Traverse right subtree

⏱️ Time Complexity (TC)
O(n)


Because:

You visit every node exactly once

💾 Space Complexity (SC)
O(h)


Where h = height of the tree
Because:

Recursive calls store function frames on the call stack

Worst case height:

Skewed tree → h = n → O(n)

Balanced tree → h = log n → O(log n)
*/

public class In_Order_Traversal {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int n) {
            val = n;
        }
    }

    public static void inOrder(Node root)
    {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("The In Order Traversal of the Binary Tree is as follows: ");
        inOrder(root);

    }
}
