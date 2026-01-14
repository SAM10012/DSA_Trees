/* Problem Statement

Symmetric Tree / Mirror Tree Check

You are given the root node of a binary tree.
Your task is to determine whether the tree is symmetric around its center.

A tree is symmetric if the left subtree is a mirror image of the right subtree.

Example of a Symmetric Tree
        1
      /   \
     2     2
    / \   / \
   3  4  4   3

Example of a Non-Symmetric Tree
        1
      /   \
     2     2
      \      \
       3      3

✅ Approach

Use a recursive function isMirror(t1, t2) that checks:

Both nodes are null → symmetric

One is null and the other isn’t → not symmetric

Values must match

Recursively check:

left subtree of t1 with right subtree of t2

right subtree of t1 with left subtree of t2

⏱ Time Complexity (TC)
O(n)

Where n = number of nodes in the tree.

🧠 Reason:
Every node is visited exactly once while comparing the left and right subtrees.

📦 Space Complexity (SC)
O(h)

Where h = height of the tree (recursive call stack).

Worst case (skewed tree): O(n)
Best case (balanced tree): O(log n)

🔍 Why O(h)?

Because at most, the recursion goes as deep as the height of the tree.
No additional data structures are used.
*/

public class Symmetric_Tree {

    public static class Node
    {
        int val;
        Node left;
        Node right;

        public Node (int n)
        {
            val = n;
        }

    }

    public static boolean checkSymmetricTree(Node root) {
        if (root == null) return true;
        else {
            return isMirror(root.left, root.right);
        }
    }

    public static boolean isMirror(Node t1, Node t2)
    {


            if(t1 == null && t2 == null) return true;
            if(t1 == null || t2 == null) return false;

            return(t1.val == t2.val && (isMirror(t1.left, t2.right) && (isMirror(t1.right,t2.left))));

        }


    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        boolean check = checkSymmetricTree(root);

        System.out.println("The binary tree is symmetric: " + check);


    }

    }

