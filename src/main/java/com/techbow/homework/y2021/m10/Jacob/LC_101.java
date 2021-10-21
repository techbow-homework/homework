package com.techbow.homework.y2021.m10.Jacob;
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
public class LC_101 {
    public boolean isSymmetric(TreeNode root) {
        return ismirror(root, root);
    }

    public boolean ismirror(TreeNode left, TreeNode right){
        if(left == null && right == null){return true;}
        if(right == null || left == null){return false;}

        return (left.val == right.val)
                && ismirror(left.left, right.right)
                && ismirror(left.right, right.left);

    }
}
