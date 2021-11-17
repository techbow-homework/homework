package com.techbow.homework.y2021.m09.WooWooLily;
import java.util.*;



public class LC_145 {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        postOrder(root, res);

        return res;

    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;

        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
}
