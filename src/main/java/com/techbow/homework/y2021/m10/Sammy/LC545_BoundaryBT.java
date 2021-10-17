package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.List;

public class LC545_BoundaryBT {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        //preorder.
        res.add(root.val);
        addLeft(root.left, res);
        addLeaves(root.left, res);
        addLeaves(root.right, res);
        addRight(root.right, res);

        return res;
    }
    private void addLeft(TreeNode root,  List<Integer> res ){
        if(root == null) return;
        //don't add the leaves val
        if(root.left == null && root.right == null) return;

        if(root.left != null) {
            res.add(root.val);
            addLeft(root.left, res);
        } else if(root.right != null) {
            res.add(root.val);
            addLeft(root.right, res);
        }
    }
    private void addLeaves(TreeNode root, List<Integer> res) {
        if(root == null) return;

        addLeaves(root.left, res);
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        addLeaves(root.right, res);
    }
    private void addRight(TreeNode root, List<Integer> res) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        if(root.right != null) {
            addRight(root.right, res);
            res.add(root.val);
        } else if(root.left != null) {
            addRight(root.left, res);
            res.add(root.val);
        }

    }
}
