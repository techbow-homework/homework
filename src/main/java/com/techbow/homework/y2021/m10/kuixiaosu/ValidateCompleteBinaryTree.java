package com.techbow.homework.y2021.m10.kuixiaosu;

public class ValidateCompleteBinaryTree {
    public boolean levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while (!que.isEmpty()) {
            TreeNode pollNode = que.poll();

            if (pollNode == null) {
                flag == true;
            }
            else if (flag == false) {
                que.offer(pollNode.left);
                que.offer(pollNode.right);
            }
            else return false;
        }
        return true;
    }
}
