package com.techbow.homework.y2021.m09.小宋小宋;

import java.util.ArrayList;
import java.util.List;


public class BFS_102 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        levelOrderHelper(root, 0);
        return res;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);

        if (root.left != null) levelOrderHelper(root.left, level + 1);
        if (root.right != null) levelOrderHelper(root.right, level + 1);
    }
}
