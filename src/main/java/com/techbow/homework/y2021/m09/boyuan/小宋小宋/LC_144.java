package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_144 {
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderHelper(root);
        return res;
    }
    private void preorderHelper(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorderHelper(root.left);
        preorderHelper(root.right);
    }
}
