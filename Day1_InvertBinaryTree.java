/**
 * /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Invert a binary tree. means swap left and right subtrees for every node.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

Trivia:
This problem was inspired by the original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */
class Day1_InvertBinaryTree {

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value)
        {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode invertBinaryTree (TreeNode root) {
        
        if (root == null)
            return null;
        
        TreeNode left = invertBinaryTree(root.left);
        TreeNode right = invertBinaryTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}