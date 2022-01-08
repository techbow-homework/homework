package com.techbow.homework.y2021.m10.rantao;

public class treeNov22 {
     public class TreeNode {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return subRoot == null;
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean isSame(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;

        if(n1.val != n2.val) return false;
        return isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }
}

