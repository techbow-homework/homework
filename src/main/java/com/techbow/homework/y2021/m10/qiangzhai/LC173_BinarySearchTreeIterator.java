package com.techbow.homework.y2021.m10.qiangzhai;

public class LC173_BinarySearchTreeIterator {
    class BSTIterator {
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushNode(root);//左子树左边走到底
        }

        public int next() {
            TreeNode temp = stack.pop();
            if (temp != null) {//进入while之前需要check null
                pushNode(temp.right);//右子树需要左边走到底
            }
            return temp.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushNode(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }
}
