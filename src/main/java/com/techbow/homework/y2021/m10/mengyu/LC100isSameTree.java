package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

public class LC100isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, p.right);
    }
}
