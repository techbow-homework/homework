package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_145 {
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return res;
    }
    private void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        res.add(root.val);
    }
}
