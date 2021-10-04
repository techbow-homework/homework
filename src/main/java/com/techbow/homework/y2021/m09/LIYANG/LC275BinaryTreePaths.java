package com.techbow.homework.y2021.m09.LIYANG;

import java.util.LinkedList;
import java.util.List;


 //Definition for a binary tree node.
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

public class LC275BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root == null) return res;
        dfs(root, new StringBuilder(), res);
        return res;
    }
    private void dfs(TreeNode root, StringBuilder sb, List<String> res){
        if(root == null){
            sb.setLength(sb.length() - 2);
            res.add(sb.toString());
            return;
        }

        String temp = String.valueOf(root.val);
        sb.append(temp);
        sb.append("->");
        int size = sb.length();
        if(root.left != null && root.right != null){
            dfs(root.left, sb, res);
            sb.setLength(size);
            dfs(root.right, sb, res);
            sb.setLength(size);
        } else if(root.left == null){
            dfs(root.right, sb, res);
            sb.setLength(size);
        } else {
            dfs(root.left, sb, res);
            sb.setLength(size);
        }
    }
}
