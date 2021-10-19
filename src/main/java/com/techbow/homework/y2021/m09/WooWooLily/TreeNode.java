package com.techbow.homework.y2021.m09.WooWooLily;

public class TreeNode {
    //field
    int val;
    TreeNode left;
    TreeNode right;

    //constructors
    TreeNode() {
        this.val = 0;
        left = null;
        right = null;

    }

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }



}
