package com.techbow.homework.y2021.m10.ryanxu.LC_106;

import Library.TreeNode;

public class LC_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int iEnd = inorder.length - 1;
        int pEnd = postorder.length - 1;

        return dfs(inorder, 0, iEnd, postorder, 0, pEnd);
    }

    private TreeNode dfs(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {

        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        int val = postorder[pEnd];
        TreeNode root = new TreeNode(val);
        int i = 0;
        for (i = iStart; i <= iEnd; i++) {
            if (inorder[i] == val) {
                break;
            }
        }

        root.left = dfs(inorder, iStart, i - 1, postorder, pStart, pStart + i - iStart - 1);
        root.right = dfs(inorder, i + 1, iEnd, postorder, pStart + i - iStart, pEnd - 1);

        return root;
    }
}
