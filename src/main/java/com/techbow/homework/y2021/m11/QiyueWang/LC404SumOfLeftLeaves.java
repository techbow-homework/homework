package com.techbow.homework.y2021.m11.QiyueWang;
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
public class LC404SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return values(root);
    }
    private int values(TreeNode root){
        if(root == null) return 0;
        int val = 0;
        if(root.left != null){
            val += isLeaf(root.left) ? root.left.val : values(root.left);
        }
        if(root.right != null){
            val += values(root.right);
        }
        return val;
    }
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
