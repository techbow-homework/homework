package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0) {
            TreeNode remove = queue.remove();
            if (remove == null) {

                while (queue.size() > 0) {
                    TreeNode rightNow = queue.remove();
                    if (rightNow != null) return false;
                }
                return true;
            }
            queue.add(remove.left);
            queue.add(remove.right);
        }
        return true;
    }
}
