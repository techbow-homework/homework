package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;

public class LC98ValidBST {
    /*
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    private ArrayList<Integer> inOrderTraverse (TreeNode root, ArrayList<Integer> list) {
        if (root == null) return list;
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
        return list;
    }
     */

    //S2 recursion from top to bottom
    private boolean isBST(TreeNode root, int lowerBond, int upperBond) {
        if (root == null) return true;
        if (root.val >= upperBond || root.val <= lowerBond) {
            return false;
        }
        return isBST(root.left, lowerBond, root.val) && isBST(root.right, root.val, upperBond);
    }
}
