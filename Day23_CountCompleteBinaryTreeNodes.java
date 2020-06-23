public class Day23_CountCompleteBinaryTreeNodes {
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
    public int countNodes(TreeNode root) {
        int leftHeight = leftHeight(root);
	    int rightHeight = rightHeight(root);
        return (leftHeight == rightHeight) ? (1 << leftHeight) - 1 
									       : 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int leftHeight(TreeNode root) {
        return root == null ? 0 : 1 + leftHeight(root.left);
    }
    
    private int rightHeight(TreeNode root) {
        return root == null ? 0 : 1 + rightHeight(root.right);
    }
}