package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;

public class LC285inOrderSuccessor {
    public TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> inorderResult = new ArrayList<>();
        inorderTraverse(root, inorderResult);
        return searchForSuccessor(inorderResult, p);
    }
    private ArrayList<TreeNode> inorderTraverse(TreeNode root, ArrayList<TreeNode> result) {
        if (root == null) return result;
        inorderTraverse(root.left, result);
        result.add(root);
        inorderTraverse(root.right, result);
        return result;
    }
    private TreeNode searchForSuccessor(ArrayList<TreeNode> traverseResult, TreeNode p) {
        for (int i = 0; i < traverseResult.size() - 1; i++){
            if (traverseResult.get(i) == p && traverseResult.get(i + 1) != null) {
                return traverseResult.get(i + 1);
            }
        }
        return null;
    }
}
