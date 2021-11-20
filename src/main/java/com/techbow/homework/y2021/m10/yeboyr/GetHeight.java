package com.techbow.homework.y2021.m10.yeboyr;

public class GetHeight {
    public int geiHeight(TreeNode root){
        if(root==0) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        //a?b:c;
        return (leftHeight == 0 || rightHeight == 0)? leftHeight+rightHeight : Math.min(leftHeight,rightHeight)+1;
    }
        if (left==0) return right+1;
        if (right==0) return left+1;
        return Math.min(left,right)+1;
}
