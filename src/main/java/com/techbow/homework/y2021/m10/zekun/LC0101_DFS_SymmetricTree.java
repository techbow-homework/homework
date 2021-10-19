package LC;

public class LC0101_DFS_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return symmetricHelper(root.left, root.right);
    }
    private boolean symmetricHelper(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        return (p.val == q.val) && symmetricHelper(p.left, q.right) && symmetricHelper(p.right, q.left);
    }
}
