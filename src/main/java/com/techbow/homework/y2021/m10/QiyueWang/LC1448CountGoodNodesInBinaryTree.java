package com.techbow.homework.y2021.m10.QiyueWang;

public class LC1448CountGoodNodesInBinaryTree {
    public static int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    private static int dfs(TreeNode root, int parentVal){
        if(root == null) return 0;
        int res = 0;
        if(root.val >= parentVal){
            parentVal = root.val;
            res = 1;
        }
        return res + dfs(root.left, parentVal) + dfs(root.right, parentVal);
    }
}
