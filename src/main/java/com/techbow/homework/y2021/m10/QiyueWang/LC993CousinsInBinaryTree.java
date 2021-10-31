package com.techbow.homework.y2021.m10.QiyueWang;

public class LC993CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] d1 = dfs(root, x, 0, 0);
        int[] d2 = dfs(root, y, 0, 0);
        //System.out.println(d1[0]+ " : " +d1[1]);
        //System.out.println(d2[0]+ " : " +d2[1]);
        return  d1[1] == d2[1] ? d1[0] != d2[0] : false;
    }
    private int[] dfs(TreeNode root, int x, int depth, int parent){
        if(root == null) return new int[]{-1,-1};
        if(root.val == x) return new int[] {parent, depth};
        int[] left = dfs(root.left, x, depth + 1, root.val);
        int[] right = dfs(root.right, x, depth + 1, root.val);
        if(left[1] != -1) return left;
        else if(right[1] != -1) return right;
        else return new int[]{-1,-1};
    }
}
