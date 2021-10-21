package com.techbow.homework.y2021.m10.kuixiaosu;

public class BFS {
    public void levelOrderTranversal(TreeNode root) {
        if (root == null){
            return;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer (root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode pollNode = que.poll();
                system.out.println (pollNode.value);
                if (pollNode.left != null){
                    que.offer(pollNode.left);
                }
                if (pollNode.right != null){
                    que.offer(pollNode.right);
                }
            }
            system.out.println();
        }
    }
}
