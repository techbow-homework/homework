package com.techbow.homework.y2021.m10.ryanxu.LC_449;

import Library.*;

import java.util.LinkedList;
import java.util.Queue;

public class LC_449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder[] preorderPath = new StringBuilder[1];
        preorderPath[0] = new StringBuilder();
        getPreorder(root, preorderPath);
        preorderPath[0].setLength((preorderPath[0].length() - 1 >= 0 ? preorderPath[0].length() - 1 : preorderPath.length));
        return preorderPath[0].toString();
    }

    private void getPreorder(TreeNode node, StringBuilder[] path) {

        if (node == null) {
            return;
        }

        path[0].append(node.val);
        path[0].append(",");
        getPreorder(node.left, path);
        getPreorder(node.right, path);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0) {
            return null;
        }
        String[] preorderArr = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String str : preorderArr) {
            if (str.equals("\u0000")) {
                continue;
            }
            queue.add(Integer.parseInt(str));
        }
        TreeNode res = dfs(Integer.MIN_VALUE, Integer.MAX_VALUE, queue);
        return res;
    }

    private TreeNode dfs(int min, int max, Queue<Integer> queue) {

        if (queue.isEmpty()) {
            return null;
        }

        int curVal = queue.peek();
        if (curVal < min || curVal > max) {
            return null;
        }
        queue.poll();
        TreeNode root = new TreeNode(curVal);
        TreeNode left = dfs(min, curVal, queue);
        TreeNode right = dfs(curVal, max, queue);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        LC_449 lc_449 = new LC_449();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String preorder = lc_449.serialize(root);
        lc_449.deserialize(preorder);
    }
}
