/* Problem Statement

Given a binary tree, find its diameter.

Diameter of a binary tree is defined as:

The maximum number of edges between any two nodes in the tree.

The diameter may or may not pass through the root.

Time Complexity (TC)
O(n)


Every node in the tree is visited exactly once.

Each visit does constant work (calculating left & right height, updating diameter).

🧠 Space Complexity (SC)
O(h)


Where h = height of the tree.

This is because the recursion stack depends on tree height.

Cases:
Tree Type	Height (h)	Space Complexity
Balanced Tree	log(n)	O(log n)
Skewed Tree (like a linked list)	n	O(n)
*/

public class Diameter_of_Binary_Tree {

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int n)
        {
            val = n;
        }
    }
    static int diameter = 0;
    public static int calcMathPathLen(Node root)
    {
        if(root == null)
            return 0;

        int left_len = calcMathPathLen(root.left);
        int right_len = calcMathPathLen(root.right);

        diameter = Math.max(diameter, left_len + right_len);

        return 1 + Math.max(left_len,right_len);

    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);

        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);

        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);


        calcMathPathLen(root);

        System.out.println("The diameter of the binary tree is: " + diameter);


    }
}

