package com.techbow.homework.y2021.m10.kuixiaosu;

public class PrintNullLevelOrderTraversal {
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    system. out. println(cur.val);
                    queue.offer(cur.left); //必须要放到 if(cur != null)的条件后面
                    queue.offer(cur.right); //必须要放到 if(cur != null)的条件后面
                } else {
                    system. out. println(“NULL”);
                }
            }
            system.out.println();
        }
    }
}
