/* Problem Statement

Given the root of a binary tree, return the list of node values that are visible when the tree is viewed from the right side.

From each level of the tree, only the rightmost node should be visible.

Example:

Input tree:

    1
   / \
  2   3
 /
4


Output:

[1, 3, 4]

📌 Approach Used — BFS (Level Order Traversal)

Use a queue to traverse the tree level-by-level.

For each level:

Process all nodes in that level.

The last node of the level (i.e., rightmost node) is added to the result list.

Add left child, then right child, to the queue.

⏱ Time Complexity: O(n)

Reason:

Each of the n nodes is:

added to the queue once

removed from the queue once

processed once

Total operations = O(n)

💾 Space Complexity: O(n)

Reason:

In the worst case (skewed tree), the queue may store up to n nodes.

In a balanced tree, the queue stores up to n/2 nodes at the bottom level.

Queue space = O(n)
Result list = O(h) ⟶ O(n) worst case
Total = O(n)
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Right_Side_View {

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int n)
        {
            val = n;
        }
    }

    public static ArrayList<Integer> rightSideView(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0; i< size; i++)
            {
                Node curr = queue.poll();

                if(i == size - 1)
                    result.add(curr.val);

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }

        return result;

    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.right.right = new Node(5);

        root.left.left.left = new Node(6);

        root.left.left.left.left = new Node(7);

        ArrayList<Integer> view = rightSideView(root);

        System.out.println("The right side view of the given binary tree is: " + view);
    }
}
