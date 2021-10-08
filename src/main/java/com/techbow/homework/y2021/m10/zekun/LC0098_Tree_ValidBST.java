package LC;

public class LC0098_Tree_ValidBST {
    public boolean isValidBST(TreeNode root) {
        Integer[] prev = new Integer[1];
        prev[0] = null;
        return helper(root, prev);
    }

    private boolean helper(TreeNode root, Integer[] prev){
        if(root == null){
            return true;
        }
        if(!helper(root.left, prev)){
            return false;
        }
        if(prev[0] != null && root.val <= prev[0]){
            return false;
        }
        prev[0] = root.val;
        return helper(root.right, prev);
    }
}
