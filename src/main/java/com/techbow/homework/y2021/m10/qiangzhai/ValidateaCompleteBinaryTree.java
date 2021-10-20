package com.techbow.homework.y2021.m10.qiangzhai;

public class ValidateaCompleteBinaryTree {
    //s1: 遍历null
    public boolean validateCompleteTree(TreeNode root) {//没有分层打印
        Queue<TreeNode>() que = new LinkedList<TreeNode>();
        //cc
        if (root == null) return;
        que.offer(root);
        boolean flag = false;
        while (!que.isEmpty() || ) {
            TreeNode pollNode = que.poll();
            if (pollNode == null) {
                flag = true;//set flag
            } else {
                if (flag == true) return false;//check flag
                que.offer(pollNode.left);
                que.offer(pollNode.right)
            }
        }
        return true;//不要忘了！！
    }
    //s2:不遍历null
    public boolean validateCompleteTree(TreeNode root) {//没有分层打印
        Queue<TreeNode>() que = new LinkedList<TreeNode>();
        //cc
        if (root == null) return;
        que.offer(root);
        boolean flag = false;
        while (!que.isEmpty()) {
            TreeNode pollNode = que.poll();
            if (pollNode.left != null) {
                if (flag == true) return false;
                que.offer(pollNode.left);
            } else {
                flag = true;
            }
            if (pollNode.right != null) {
                if (flag == true) return false;
                que.offer(pollNode.right);
            } else {
                flag = true;
            }
        }
        return true;
    }




}
