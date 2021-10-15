package com.techbow.homework.y2021.m10.eva;


public class LC_543 {
        int diameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);
            return diameter - 1;
        }
        private int helper(TreeNode root){
            if (root == null) return 0;
            int leftLen = helper(root.left);
            int rightLen = helper(root.right);
            diameter = Math.max(diameter, leftLen + rightLen + 1);
            return Math.max(leftLen, rightLen) + 1;
        }

    public static void main(String[] args) {

    }

}


