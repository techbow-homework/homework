package com.techbow.homework.y2021.m10.kuixiaosu;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrderTraversal (TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue <TreeNode> que = new LinkedList<TreeNode>();

        que.offer(root);
        while (! que.isEmpty()) {
            int size = que.size();
            List <Integer> list = new ArrayList<Integer> ();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
