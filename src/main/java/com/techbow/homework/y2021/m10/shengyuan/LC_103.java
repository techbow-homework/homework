package com.techbow.homework.y2021.m10.shengyuan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode() {

    }
    TreeNode(int value) {
        this.value = value;
    }
    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class LC_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (flag) {
                    list.add(node.value);
                } else {
                    list.addFirst(node.value);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        LC_103 test = new LC_103();
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(23);
        List<List<Integer>> result = test.zigzagLevelOrder(root);
        System.out.println(result);
    }
}
