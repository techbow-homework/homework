package com.techbow.homework.y2021.m10.zekun;

public class LC0404_Tree_SumLeftLeaf {
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfsHelper(root, false);
        return sum;
    }

    private int dfsHelper(TreeNode root, boolean isLeft){
        if(root == null) return 0;
        if(root.left == null && root.right == null && isLeft){
            sum += root.val;
        }
        if(root.left != null) dfsHelper(root.left, true);
        if(root.right != null) dfsHelper(root.right, false);
        return sum;
    }
}
