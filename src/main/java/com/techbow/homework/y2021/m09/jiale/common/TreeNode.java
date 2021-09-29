package com.techbow.homework.y2021.m09.jiale.common;

/**
 * Definition for a binary tree node
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode () {}
    public TreeNode (int val) {
        this.val = val;
    }
    public TreeNode (int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = left.right;
    }
}
