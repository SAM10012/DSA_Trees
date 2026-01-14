/* Problem Statement

You are given the root node of a binary tree.
Your task is to determine the maximum depth (also known as the height) of the tree.

The maximum depth is defined as:

The number of nodes along the longest path from the root node down to the farthest leaf node.

For example:

       1
      / \
     2   3
        / \
       4   5
      /
     6


The maximum depth of this tree is 5.

Return the depth as an integer.

✅ Time Complexity (TC)
O(n)

Where n = number of nodes in the binary tree.

Reason:

We visit each node exactly once.

Each recursive call processes one node.

✅ Space Complexity (SC)
O(h)

Where h = height of the tree.

This is due to the recursion call stack.

Two cases:

✔ Best Case (Balanced Tree)

Height: log n

Space Complexity: O(log n)

Because recursion depth is small.

❌ Worst Case (Skewed Tree)

Height: n

Space Complexity: O(n)

For example, a chain like:

1
 \
  2
   \
    3
     \
      4


Recursion goes n levels deep.

📌 Summary Table
Case	        Height	Space Complexity
Balanced Tree	log n	O(log n)
Skewed Tree	       n	O(n)
Time Complexity	—	O(n)
*/

public class Max_Depth_of_Binary_Tree {

    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int n)
        {
            val = n;
            left = null;
            right = null;
        }
    }

    public static int findMaxDepth(Node root)
    {
        if(root == null)
            return 0;

        int left_depth = findMaxDepth(root.left);
        int right_depth = findMaxDepth(root.right);

        return (1 + Math.max(left_depth,right_depth));
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);

        root.right.left.left = new Node(6);
        root.right.left.left.left = new Node(7);

        int max_depth = findMaxDepth(root);

        System.out.println("The max depth of the binary tree is: " + max_depth);




    }
}
