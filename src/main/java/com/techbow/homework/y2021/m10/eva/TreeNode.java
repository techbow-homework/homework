package com.techbow.homework.y2021.m10.eva;

import com.sun.source.tree.Tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public void root(int val) {
        this.val = val;
    }
    public void root(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
