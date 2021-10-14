package com.techbow.homework.y2021.m09.QiyueWang;

class TreeNode {
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

public class LC1008ConstructBinarySearchTreeFromPreorderTraversal {
    private static int index = 0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder,  Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static TreeNode dfs(int[] preorder, int low, int high){
        if(index == preorder.length) return null;
        int curVal = preorder[index];
        if(curVal > high || curVal < low) return null;
        index ++;
        TreeNode root = new TreeNode(curVal);
        root.left = dfs(preorder,  low, curVal);
        root.right = dfs(preorder, curVal, high);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{8,5,1,7,10,12};
        bstFromPreorder(preorder);
    }
}
// time O(N) space O(N)