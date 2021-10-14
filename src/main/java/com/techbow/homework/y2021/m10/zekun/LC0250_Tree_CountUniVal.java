package com.techbow.homework.y2021.m10.zekun;

public class LC0250_Tree_CountUniVal {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        //cc
        if(root == null) return 0;
        dfsHelper(root);//it doesnt matter to set val to 0 or something
        return count;
    }

    private boolean dfsHelper(TreeNode root){
        if(root == null) return true;
        //left tree
        boolean l = dfsHelper(root.left);
        boolean r = dfsHelper(root.right);//left and right are mutual exclusive, should not go left fail then not go right;
        if(!l || !r) return false;
        if((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)){//has to check if left and right are null, or will get NPE; left is null has to also  check right is null or not. not null has to further go right;
            count++;
            return true;
        }else{
            return false;
        }
        //count++;
        //return root.val == target;
    }
}
