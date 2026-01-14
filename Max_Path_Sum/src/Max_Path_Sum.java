/* Problem Statement

Binary Tree Maximum Path Sum

Given a binary tree, return the maximum path sum.
A path can start and end at any node, but it must follow parent–child connections (no jumps).

A path may go:

only left

only right

left → root → right

root alone

Nodes may contain negative values.

Time Complexity (TC)
O(n)

Because:

Every node is visited exactly once

Each visit performs O(1) operations

This is optimal for tree problems — we must examine all nodes.

🧠 Space Complexity (SC)
O(h)

Where h = height of the tree.

Balanced tree: O(log n)

Skewed tree (worst case): O(n)

Space is due to recursion stack.
*/

public class Max_Path_Sum {

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int n)
        {
            val = n;
        }
    }
    static int sum = Integer.MIN_VALUE;
    public static int calcMathPathSum(Node root)
    {
        if(root == null)
            return 0;

        int left_max = Math.max(calcMathPathSum(root.left),0);
        int right_max = Math.max(calcMathPathSum(root.right),0);

        sum = Math.max(sum, root.val + left_max + right_max);

        return root.val + Math.max(left_max,right_max);
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);

        calcMathPathSum(root);

        System.out.println("The max path sum in the binary tree is: " + sum);


    }
}
