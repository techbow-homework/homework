package LC;

public class LC0112_Tree_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //cc
        if(root == null) return false;//
        if(root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }
}
