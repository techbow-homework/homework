package com.techbow.homework.y2021.m10.QiyueWang;

import java.util.Deque;
import java.util.LinkedList;

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

public class LC671MergeTwoBinaryTrees {

     public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         if(root1 == null) return root2;
         if(root2 == null) return root1;

         root1.val += root2.val;
         root1.left = mergeTrees(root1.left, root2.left);
         root1.right = mergeTrees(root1.right, root2.right);

         return root1;
     }

        public TreeNode mergeTreesIter(TreeNode root1, TreeNode root2){
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        Deque<TreeNode[]> stack = new LinkedList<>();
        stack.offerLast(new TreeNode[]{root1, root2});

        while(!stack.isEmpty()){
            TreeNode[] cur = stack.pollLast();

            if(cur[0] == null || cur[1] == null){
                continue;
            }

            cur[0].val += cur[1].val;

            if(cur[0].left == null){
                cur[0].left = cur[1].left;
            }else{
                stack.offerLast(new TreeNode[]{ cur[0].left, cur[1].left});
            }

            if(cur[0].right == null){
                cur[0].right = cur[1].right;
            }else{
                stack.offerLast(new TreeNode[]{ cur[0].right, cur[1].right});
            }
        }
        return root1;

    }

    public static void main(String[] args) {

    }

}
// time O(N) space O(N) N is the min number of nodes of the two trees