package com.techbow.homework.y2021.m10.qiangzhai;

public class LC102_BinaryTreeLevelOrderTraversal {
    public void levelOrderTraversal(TreeNode root) {//没有分层打印
        Queue<TreeNode>() que = new LinkedList<TreeNode>();
        //cc
        if (root == null) return;
        //step 1: push root
        que.offer(root);
        while (!que.isEmpty()) {
            //step 2: expand
            TreeNode pollNode = que.poll();
            //这里无脑打印，所以下面offer之前要check null
            //就导致null进不去，不能do sth
            //可以在这里check null，offer时不check
            //如果是null，打印null
            System.out.println(pollNode.value);//visit
            //step 3: convert
            if (pollNode.left != null) {
                que.offer(pollNode.left);
            }
            if (pollNode.right != null) {
                que.offer(pollNode.right);
            }
        }
    }
    public List<List<Integer>> level(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        //Collections.reverse(result);
        return result;
    }
//follow up:要求打印leaf node下面挂着的null
//while loop
    while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            if (pollNode == null) {
                System.out.println("NULL");
         } else {
                System.out.println(pollNode.val);
                queue.offer(pollNode.left);
                queue.offer(pollNode.right);
         }
    }

}
