package QW;

import java.util.ArrayList;
import java.util.List;

public class LC99RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        dfs(root, inorder);
        int n = inorder.size();
        TreeNode[] mistake = new TreeNode[2];
        int count = 0;
        //find exchanged elements
        int index1 = -1, index2 = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (inorder.get(i + 1).val < inorder.get(i).val) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        // for(TreeNode t : inorder){
        //     System.out.println(t.val);
        // }
        // System.out.println("  " + mistake[0].val);
        // System.out.println("  " + mistake[1].val);
        exchange(root, inorder.get(index1).val, inorder.get(index2).val);

    }
    private void dfs(TreeNode root, List<TreeNode> inorder){
        if(root == null) return;
        dfs(root.left, inorder);
        inorder.add(root);
        dfs(root.right,inorder);
    }
    private void exchange(TreeNode root, int v1, int v2){
        if(root == null) return;
        if(root.val == v1) root.val = v2;
        else if(root.val == v2) root.val = v1;
        exchange(root.left, v1, v2);
        exchange(root.right, v1, v2);
    }
}
