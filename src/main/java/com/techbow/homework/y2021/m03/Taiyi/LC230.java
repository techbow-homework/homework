package com.techbow.homework.y2021.m03.Taiyi;


import java.util.ArrayList;
import java.util.Stack;

public class LC230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> Iterator = new Stack<>();

        TreeNode cur = root;
        while (cur != null){
            Iterator.push(cur);
            cur = cur.left;
        }
        while (!Iterator.isEmpty()){
            TreeNode temp = Iterator.pop();
            if (--k == 0) return temp.val;
            TreeNode next = temp.right;
            while(next != null){
                Iterator.push(next);
                next = next.left;
            }

        }
        return -1;
    }
}
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
