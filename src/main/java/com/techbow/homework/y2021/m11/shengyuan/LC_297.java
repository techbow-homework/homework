package com.techbow.homework.y2021.m11.shengyuan;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class LC_297 {
    // Encodes a tree to a single string
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }
    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    //Decodes your encoded data to tree
    public TreeNode deserializeToTreeNode(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        List<String> list = new LinkedList<>();
        for (String str : arr) {
            list.add(str);
        }
        return buildTree(list);
    }
    private TreeNode buildTree(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode cur = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        cur.left = buildTree(list);
        cur.right = buildTree(list);

        return cur;
    }
}
