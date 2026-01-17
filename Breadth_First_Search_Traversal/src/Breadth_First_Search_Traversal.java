/* Problem Statement

Given a binary tree, perform a level order traversal and return all the nodes level-by-level.
Each level should be returned as a separate list.

Your output format must be:

[
  [level1 nodes],
  [level2 nodes],
  [level3 nodes],
  ...
]


For example, for the tree:

        1
      /   \
     2     3
    / \   / \
   4  5  6   7


The output should be:

[[1], [2, 3], [4, 5, 6, 7]]

🧠 Explanation of Approach

Use a Queue for BFS traversal:

Push root into queue

Loop until queue is empty

At each level:

Determine current level size (queue.size())

Process exactly that many nodes

Push their children into queue

Add this level's values to the result

⏱ Time Complexity
O(n)

Where n = number of nodes in the tree.

Reason:

Every node is enqueued exactly once

Every node is dequeued exactly once

All operations inside the loop are O(1)

Total = O(n)

💾 Space Complexity
O(n)

Reason:

The queue can hold up to the maximum number of nodes at the widest level → O(n)

The result list also stores all nodes → O(n)

So overall space usage:

O(n + n) → O(n)
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Breadth_First_Search_Traversal {

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int n)
        {
            val = n;
        }
    }

    public static ArrayList<ArrayList<Integer>> BFS(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        queue.offer(root);

        while(!queue.isEmpty())
        {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node curr = queue.poll();
                level.add(curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            list.add(level);

        }

        return list;
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<ArrayList<Integer>> bfs_traversal = BFS(root);

        System.out.println(bfs_traversal);

    }
}
