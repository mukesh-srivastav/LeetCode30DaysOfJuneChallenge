/**
 * Definition for a binary tree node.
 */
import java.util.*;

class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
   }
    List<String> res;
    public int sumNumbers(TreeNode root) {
        res = new ArrayList<>();
        
        dfs(root, "");
        
        int total = 0;
        for (String num : res) {
            total += Integer.parseInt(num);
        }
        return total;
    }
    
    void dfs (TreeNode root, String curr) {
        if (root == null)
            return;
        
        curr = curr + root.val;
        
        if (root.left == null && root.right == null) {
            res.add(curr);
            return;
        }
        
        
        dfs(root.left, curr);
        dfs(root.right, curr);
    }
}