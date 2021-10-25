package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC101SymmetricTree {
    public boolean isSymmetricTree (TreeNode root) {
        /*
        offer root into a queue twice
        pull one out, compare root1.left to root2.right
        root1.right to root2.left
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null) {
                return false;
            } else if (node1.val == node2.val) {
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            } else {
                return false;
            }
        }
        return true;
    }
}
