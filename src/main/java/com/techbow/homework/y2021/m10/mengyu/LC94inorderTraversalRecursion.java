package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC94inorderTraversalRecursion {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal (TreeNode root) {
        if (root == null) return result;
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
