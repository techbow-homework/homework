package com.techbow.homework.y2021.m09.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * preorder traversal bst
 */
public class LC_144 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversalRecur(root);
        return result;
    }

    private void preorderTraversalRecur(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderTraversalRecur(node.left);
        preorderTraversalRecur(node.right);
    }
}
